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
	
	public synchronized PCB getFirst()
	{
		return QReady.getFirst() ;
	}
		
	public synchronized PCB getLast()
	{
		return QReady.getLast()	;
	}
	
	public synchronized PCB get(int	i0)
	{
		return QReady.get(i0)	;
	}
	
	//	set methods
	
	public synchronized void addFirst(PCB pcb0)
	{
		QReady.addFirst(pcb0)	;
	}
	
	public synchronized void addLast(PCB pcb0)
	{
		QReady.addLast(pcb0)	;
	}
	
	public synchronized void add(int i0	,PCB pcb0)
	{
		QReady.add(i0, pcb0)	;
	}
}