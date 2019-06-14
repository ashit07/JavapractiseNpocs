package sorting;

import sorting.SortingTypes.SortingType;

public class SortFactory {

  private final static SortFactory instance = new SortFactory();
  private SortFactory() {

  }
  public static SortFactory getInstance() {
    return instance;
  }
  public Sorting getSortingInstance(SortingType sortType) {
    Sorting sortInstance = null;
    if(sortType.equals(SortingType.QUICK_SORT)){
      sortInstance = new QuickSort();
    }
    return sortInstance;
  }

}
