class MismatchUpperTriangleMatrixSizeException extends Exception
{
    public static final String ERROR_MSG = "Upper triangle matrix not same size";
    public MismatchUpperTriangleMatrixSizeException(String errorMsg)
    {
        super(errorMsg);
    }
}