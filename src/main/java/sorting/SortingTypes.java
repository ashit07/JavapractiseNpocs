package sorting;


public class SortingTypes {
  public enum SortingType  {

      QUICK_SORT("quickSort"),
      MERGER_SORT("mergeSort"),
      INSERTION_SORT("insertionSort");

      private String sortType;

      private SortingType(String sortType) {
          this.sortType = sortType;
      }

      public String getSortType() {
          return sortType;
      }

  };
}
