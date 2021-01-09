import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App{
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String, Object> model= new HashMap<String, Object>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}