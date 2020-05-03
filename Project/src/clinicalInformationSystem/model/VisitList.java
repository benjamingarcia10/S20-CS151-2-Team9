package clinicalInformationSystem.model;
import java.util.ArrayList;
import java.util.Date;

/**
 * List of visits registered to this clinical information system.
 * The visits are ordered by their date of visit
 * @author Team 9
 *
 */
public class VisitList extends ArrayList<VisitModel>
{
	/**
	 * Constructs a VisitList as an empty ArrayList
	 */
	public VisitList()
	{
		super();
	}
	
	/**
	 * Add a visit to this list of visits
	 * @param v the visitModel to add to this list
	 */
	public void addVisit(VisitModel v)
	{
		super.add(v);
	}
	
	public VisitList getVisitsByDate(Date d)
	{
		VisitList visits = new VisitList();
		for(VisitModel visit: this)
		{
			if(visit.getDateOfVisit().equals(d))
				visits.add(visit);
		}
		return visits;
	}
	
	public VisitList getVisitsByPatient(PatientModel patient)
	{
		VisitList visits = new VisitList();
		for(VisitModel visit: this)
		{
			if(visit.getPatient().equals(patient))
				visits.add(visit);
		}
		return visits;
	}
}
