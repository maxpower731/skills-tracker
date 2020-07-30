package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {

    @GetMapping
    @ResponseBody
    public String printProgrammingLanguages() {
        String skillsTracker = "Skills Tracker";
        String javaScript = "JavaScript";
        String java = "Java";
        String typeScript = "TypeScript";

        return "<h1>" +
                skillsTracker +
                "</h1>" +
                "<h2>" +
                "These are the languages you should be working on:" +
                "</h2>" +
                "<ol>" +
                "<li>" +
                javaScript +
                "<li>" +
                java +
                "<li>" +
                typeScript +
                "</ol>";
    }

    @GetMapping("form")
    @ResponseBody
    public String formMethod() {
        String options = "<option value='JavaScript'>JavaScript</option>" +
                "<option value='Java'>Java</option>" +
                "<option value='TypeScript'>TypeScript</option>";

        String html =  "" +
                "<html>" +
                "<body style='display:inline-block'>" +
                "<form action='rankedPage' method='post'>" + //submits request to /rankedPage
                "Name: " +
                "<input type='text' name='name'>" +
                "<br>" +
                "My favorite language:" +
                "<select name ='firstFavorite'>" +
                options+
                "</select>" +
                "<br>" +
                "My second favorite language:" +
                "<select name ='secondFavorite'>" +
                options+
                "</select>" +
                "<br>" +
                "My third favorite language:" +
                "<select name ='thirdFavorite'>" +
                options+
                "</select>" +
                "<br>" +
                "<input type='submit' value='Vote!'>" +
                "</form>" +
                "</body>" +
                "</html>";

        return html;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "rankedPage")
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String firstFavorite, @RequestParam String secondFavorite, @RequestParam String thirdFavorite) {
        return  "<html>" +
                "<body>" +
                "<h1>" +
                name +
                "</h1>" +
                "<ol>" +
                "<li>" +
                firstFavorite +
                "<li>" +
                secondFavorite +
                "<li>" +
                thirdFavorite +
                "</ol>" +
                "</body>" +
                "</html>";
    }
}
