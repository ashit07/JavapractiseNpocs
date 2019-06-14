package collections.map;

import java.util.Comparator;

public class TreeMapDescending  {
	int id;
	public TreeMapDescending(int id) {
		this.id=id;
	}
	@SuppressWarnings("rawtypes")
	Comparator c = new Comparator () {
		@Override
		public int compare(Object paramT1, Object paramT2) {
			if (paramT1 ==null || paramT2 == null) {
				return (Integer) null;
			}
			if ((paramT1 instanceof TreeMapDescending) && (paramT2 instanceof TreeMapDescending) ) {
				return (((TreeMapDescending) paramT1).getID ())- (((TreeMapDescending) paramT2).getID());
			} 
			return 0;
		}
		
	};
	public int getID () {
		return id;
	}


}
