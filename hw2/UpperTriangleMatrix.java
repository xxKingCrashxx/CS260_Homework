public class UpperTriangleMatrix implements Cloneable
{
    private String[] elementArrary;

    public UpperTriangleMatrix()
    {
        int n = 10;
        elementArrary = new String[(n*(n+1))/2];
    }

    public UpperTriangleMatrix(int size)
    {
        elementArrary = new String[(size*(size+1))/2];
    }

    @Override
    public UpperTriangleMatrix clone() throws CloneNotSupportedException
    {
        UpperTriangleMatrix clonedObj;
        try 
        {
            //using object built in clone
            clonedObj = (UpperTriangleMatrix)super.clone();

            //deep copy of string array
            clonedObj.elementArrary = elementArrary.clone();
        } 
        catch (CloneNotSupportedException e) 
        {
            throw new CloneNotSupportedException("This object does not support cloneing");
        }
        return clonedObj; 
    }

    public static UpperTriangleMatrix concat(UpperTriangleMatrix utm1, UpperTriangleMatrix utm2)
    {
        return null;
    }

    public static UpperTriangleMatrix largestCombo(UpperTriangleMatrix utm1, UpperTriangleMatrix utm2)
    {
        return null;
    }

    public boolean equals(Object ob)
    {
        return false;
    }

    public void setElement(int row, int col, String data)
    {

    }

    public String getElement(int row, int col)
    {
        return null;
    }

    public String toString()
    {
        return null;
    }
    
}
