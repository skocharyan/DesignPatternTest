package org.example.tools;

import java.io.*;
import java.util.List;
import java.util.Random;

public class GetLoginAndPassword {
    private String  loginFileName ;
    private String passwordFileName;
    ClassLoader classLoader = GetLoginAndPassword.class.getClassLoader();

    public String getRandomLoginOrPassword(String loginOrPassword) throws IOException {
     switch(loginOrPassword){
         case "login":   loginFileName = "login.txt"; break;
         case "password":   loginFileName = "password.txt"; break;
         default:
     }
        String login;
        File file = new File(classLoader.getResource(loginFileName).getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> loginList = null;
        while ((login = br.readLine()) != null){
            loginList.add(login);
        }
        int loginListSize = loginList.size();
        int randomInt =  new Random().nextInt(loginListSize);
        return loginList.get(randomInt);
    }
}
