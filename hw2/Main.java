public class Main 
{

    public static void main(String[] args) throws Exception
    {
        UpperTriangleMatrix utm = new UpperTriangleMatrix(5);
        utm.setElement(0, 0, "00");
        utm.setElement(0, 1, "01");
        utm.setElement(0, 2, "02");
        utm.setElement(0, 3, "03");
        utm.setElement(0, 4, "04");
        utm.setElement(1, 1, "11");
        utm.setElement(1, 2, "12");
        utm.setElement(1, 3, "13");
        utm.setElement(1, 4, "14");
        utm.setElement(2, 2, "22");
        utm.setElement(2, 3, "23");
        utm.setElement(2, 4, "24");
        utm.setElement(3, 3, "33");
        utm.setElement(3, 4, "34");
        utm.setElement(4, 4, "44");

        utm.toString();
        System.out.println("element in index 00:" + utm.getElement(0, 0));

    }
    
}
