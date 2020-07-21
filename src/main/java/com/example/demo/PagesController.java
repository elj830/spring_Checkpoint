package com.example.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PagesController {

    @GetMapping("/camelize")
    public String camelize(
            @RequestParam(value="original") String orig,
            @RequestParam(value="initialCap") Boolean cap){

        System.out.println("test");
        String[] camelCase = orig.split("_");

        if (cap == true){
            camelCase[0] = camelCase[0].substring(0,1).toUpperCase() + camelCase[0].substring(1);
        }

        for (int i = 1; i < camelCase.length; i++){

            camelCase[i] = camelCase[i].substring(0,1).toUpperCase() + camelCase[i].substring(1);
        }
        String ret = String.join("",camelCase);
        System.out.println(ret);
        return ret;
    }

    @GetMapping("/redact")
    public String badWords(
        @RequestParam(value="original")String original,
        @RequestParam(value="badWord")
        List<String> badWord){

        String[] words = original.split(" ");
        for (int i = 0; i < words.length; i++){
            if (badWord.contains(words[i])){
                words[i] = "*".repeat(words[i].length());
                System.out.println(words[i]);
            }
        }
        String ret = String.join(" ", words);
        return ret;
    }


}
