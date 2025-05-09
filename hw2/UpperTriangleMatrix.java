public class UpperTriangleMatrix implements Cloneable
{
    private String[] elementArray;
    private int matrixSideLen;

    public UpperTriangleMatrix()
    {
        matrixSideLen = 10;
        elementArray = new String[(matrixSideLen*(matrixSideLen+1))/2];
    }

    public UpperTriangleMatrix(int size)
    {
        matrixSideLen = size;
        elementArray = new String[(size*(size+1))/2];
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
            clonedObj.elementArray = this.elementArray.clone();
        } 
        catch (CloneNotSupportedException e) 
        {
            throw new CloneNotSupportedException("This object does not support cloneing");
        }
        return clonedObj; 
    }

    @Override
    public boolean equals(Object ob)
    {
        if(ob instanceof UpperTriangleMatrix)
        {
            UpperTriangleMatrix utm2 = (UpperTriangleMatrix)ob;

            if(utm2.elementArray.length != this.elementArray.length)
                return false;
            
            for (int i = 0; i < this.elementArray.length; i++) 
            {
                if(!(utm2.elementArray[i].equals(this.elementArray[i])))
                    return false;
            }
            return true;    
        }
        return false;
    }

    public void setElement(int row, int col, String data) throws Exception
    {
        if (col >= row) 
        {
            int index = ((row * matrixSideLen - (row*(row+1)/2) + col));
            elementArray[index]  = data;  
        } 
        else 
        {
            throw new Exception("Invalid index");
        }

    }

    public String getElement(int row, int col)
    {
        if(col >= row)
        {
            return elementArray[(row * matrixSideLen - (row*(row+1)/2) + col)];
        }
        else
        {
            return null;
        }

    }

    public String toString()
    {
        for (int row = 0; row < matrixSideLen; row++) {

            for (int col = 0; col < matrixSideLen; col++) 
            {
                System.out.printf("|%-15s|", this.getElement(row, col));

                if (col == matrixSideLen -1) {
                    break;
                }
            }
            System.out.println();
        }
        return null;
    }

    public static UpperTriangleMatrix concat(UpperTriangleMatrix utm1, UpperTriangleMatrix utm2) throws MismatchUpperTriangleMatrixSizeException
    {
        if(utm1.matrixSideLen != utm2.matrixSideLen)
        {
            throw new MismatchUpperTriangleMatrixSizeException(MismatchUpperTriangleMatrixSizeException.ERROR_MSG);
        }

        UpperTriangleMatrix concatUtm = new UpperTriangleMatrix(utm1.matrixSideLen);
        for (int i = 0; i < concatUtm.elementArray.length; i++) {
            concatUtm.elementArray[i] = utm1.elementArray[i] + " " + utm2.elementArray[i];
        }
        return concatUtm;
    }

    public static UpperTriangleMatrix largestCombo(UpperTriangleMatrix utm1, UpperTriangleMatrix utm2) throws MismatchUpperTriangleMatrixSizeException
    {
        if(utm1.matrixSideLen != utm2.matrixSideLen)
        {
            throw new MismatchUpperTriangleMatrixSizeException(MismatchUpperTriangleMatrixSizeException.ERROR_MSG);
        }

        UpperTriangleMatrix comboUtm = new UpperTriangleMatrix(utm1.matrixSideLen);

        for (int i = 0; i < comboUtm.elementArray.length; i++) 
        {
            if(utm1.elementArray[i].length() >= utm2.elementArray[i].length())
            {
                comboUtm.elementArray[i] = utm1.elementArray[i];
            }
            else
            {
                comboUtm.elementArray[i] = utm2.elementArray[i];
            }
        }
        return comboUtm;
    }
    
}
