import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Calendar;
import java.util.Date;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*; 

public class FileDetail{
    // Checking of Valid Expression
    int a=1;
    int b=1;
    int c=3;
    int result = (a==b ?(c=c+b) : a);

     public static void main(String []args) throws IOException{

// Example of Counting the file in a directory and group with month name...
// Directory Path:
// "E:/CompanyAssignment/Practice_react/src/"
// Directory contain files: 10

// Jan : 5
// April: 3


        String[] arr = {"Jan" ,"Feb" , "March" , "April" , "May" ,"Jun" ,"July","Aug" ,"Sep","Oct","Nov","Dec"};
         
        String fileName = "E:/CompanyAssignment/Practice_react/src/";

        Stream<Path> files = Files.list(Paths.get(fileName));
        Iterator<Path> elements  = files.iterator(); 

        int index = 0;
        while(index < 12){
            int count = 0;
            while (elements.hasNext()) { 
                try {
                    BasicFileAttributes attr =
                        Files.readAttributes(elements.next(), BasicFileAttributes.class);

                    Date newDate = new Date( attr.creationTime().toMillis() );

                    // System.out.println("creationTime: " + attr.creationTime());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(newDate);
                    int month = cal.get(Calendar.MONTH) ;
                    // System.out.println("Month name " + month );
                    if(month == index) 
                        count++;
                    // System.out.println("Locatl date " + newDate );

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(count != 0)
                System.out.println(arr[index] + count );
            index++;
    }  

     }
}