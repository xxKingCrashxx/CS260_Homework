public class UpperTriangleMatrix implements Cloneable
{
    private String[] elementArrary;
    private int matrixSideLen;

    public UpperTriangleMatrix()
    {
        matrixSideLen = 10;
        elementArrary = new String[(matrixSideLen*(matrixSideLen+1))/2];
    }

    public UpperTriangleMatrix(int size)
    {
        matrixSideLen = size;
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
            clonedObj.elementArrary = this.elementArrary.clone();
        } 
        catch (CloneNotSupportedException e) 
        {
            throw new CloneNotSupportedException("This object does not support cloneing");
        }
        return clonedObj; 
    }

    public boolean equals(Object ob)
    {
        if(ob instanceof UpperTriangleMatrix)
        {
            UpperTriangleMatrix utm2 = (UpperTriangleMatrix)ob;

            if(utm2.elementArrary.length != this.elementArrary.length)
                return false;
            
            for (int i = 0; i < this.elementArrary.length; i++) 
            {
                if(!(utm2.elementArrary[i].equals(this.elementArrary[i])))
                    return false;
                return true;
            }    
        }
        return false;
    }

    public void setElement(int row, int col, String data) throws Exception
    {
        if (row <= col && col < matrixSideLen) 
        {
            elementArrary[(row * (row +1))/2 + col] = data;  
        } 
        else 
        {
            throw new Exception("Invalid index");
        }

    }

    public String getElement(int row, int col)
    {
        if(row > col)
        {
            return null;
        }
        else
        {
            return elementArrary[(row * (row +1))/2 + col];
        }

    }

    public String toString()
    {
        return "";
    }

    public static UpperTriangleMatrix concat(UpperTriangleMatrix utm1, UpperTriangleMatrix utm2)
    {
        return null;
    }

    public static UpperTriangleMatrix largestCombo(UpperTriangleMatrix utm1, UpperTriangleMatrix utm2)
    {
        return null;
    }
    
}
