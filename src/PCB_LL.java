import java.util.LinkedList;

@SuppressWarnings("rawtypes")
public class PCB_LL
{
	private static LinkedList<PCB> QReady	;

	// constructor methods
		
	public PCB_LL ()
	{
		QReady = new LinkedList<PCB>()	;
	}	
		
	// get methods
	
	public PCB getFirst()
	{
		return QReady.getFirst() ;
	}
		
	public PCB getLast()
	{
		return QReady.getLast()	;
	}
	
	public PCB get(int	i0)
	{
		return QReady.get(i0)	;
	}
	//	set methods
		}
}