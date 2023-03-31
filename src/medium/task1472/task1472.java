class BrowserHistory {
  private final List<String> history;
  private int currentPage;
  private int size;
  public BrowserHistory(String homepage) {
      history = new LinkedList<>();
      history.add(homepage);
      currentPage = 0;
      size = 1;
  }

  public void visit(String url) {
      history.add(++currentPage, url);
      size = currentPage + 1;
  }

  public String back(int steps) {
      currentPage = Math.max(0, currentPage - steps);
      return history.get(currentPage);
  }

  public String forward(int steps) {
      currentPage = Math.min(size - 1, currentPage + steps);
      return history.get(currentPage);
  }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
