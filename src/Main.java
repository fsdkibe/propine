import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Given no parameters, return the latest portfolio value per token in USD");
        getPortfolioPerToken();
        System.out.println("Given a token, return the latest portfolio value for that token in USD");
        getPortfolioForAToken("CRYPTO:LINK");
        System.out.println("Given a date, return the portfolio value per token in USD on that date");
        getPortfolioPerTokenForAGivenDate("3232323233");
        System.out.println("Given a date and a token, return the portfolio value of that token in USD on that date");
        getPortfolioPerTokenForAGivenDateNToken("3232323235","CRYPTO:UNI");


    }

    private static void getPortfolioPerToken(){

        try (BufferedReader br = new BufferedReader(new FileReader("/home/kibe/propine.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(values[2]+"= $"+values[3]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void getPortfolioForAToken(String token){

        try (BufferedReader br = new BufferedReader(new FileReader("/home/kibe/propine.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(token.equals(values[2])){
                    System.out.println(values[2]+"= $"+values[3]);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void getPortfolioPerTokenForAGivenDate(String date){

        try (BufferedReader br = new BufferedReader(new FileReader("/home/kibe/propine.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(date.equals(values[0])){
                    System.out.println(values[2]+"= $"+values[3]);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void getPortfolioPerTokenForAGivenDateNToken(String date, String token){

        try (BufferedReader br = new BufferedReader(new FileReader("/home/kibe/propine.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(token.equals(values[2])&&date.equals(values[0])){
                    System.out.println(values[2]+"= $"+values[3]);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}