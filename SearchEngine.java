import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.*;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 3;
    ArrayList<String> myList = new ArrayList<>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return "String Search";
        } 
        else if (url.getPath().equals("/print")) {
            for (int i = 0; i < myList.size(); i++) {
                System.out.println(myList.get(i));
            }
            return String.format("end of list");
        } 
        else if (url.getPath().contains("/search")) {
            String[] parameters = url.getQuery().split("=");
            if (myList.indexOf(parameters[1]) != -1) {
                System.out.println(myList.indexOf(parameters[1]));
                return String.format("String found");
            }
            return "not found";
        }
        else {
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                    myList.add(parameters[1]);
                    return String.format("Added string");
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
