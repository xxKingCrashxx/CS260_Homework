public class Main 
{

    public static void main(String[] args) throws Exception
    {
        UpperTriangleMatrix utm = new UpperTriangleMatrix(5);
        utm.setElement(0, 0, "Mike");
        utm.setElement(0, 1, "Sammy");
        utm.setElement(0, 2, "Greggory");
        utm.setElement(0, 3, "Jeff");
        utm.setElement(0, 4, "Joseph");
        utm.setElement(1, 1, "Sarah");
        utm.setElement(1, 2, "Jennifer");
        utm.setElement(1, 3, "Lilly");
        utm.setElement(1, 4, "Lucy");
        utm.setElement(2, 2, "Samuel");
        utm.setElement(2, 3, "Michael");
        utm.setElement(2, 4, "Misty");
        utm.setElement(3, 3, "john");
        utm.setElement(3, 4, "Austin");
        utm.setElement(4, 4, "Karen");

        utm.toString();

    }
    
}
