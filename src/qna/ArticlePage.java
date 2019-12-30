package qna;

import java.util.List;
import qna.Article;

public class ArticlePage {
	
		private int total;
		private int currentPage;
		private List<Article> article;
		private int totalPages;
		private int startPage;
		private int endPage;
		
		public ArticlePage(int total, int currentPage, int size, List<Article> article) {
			this.total = total;
			this.currentPage = currentPage;
			this.article = article;
			if(total == 0) {
				totalPages = 0;
				startPage = 0;
				endPage = 0;
			} else {
				totalPages = total /size;
				if(total % size > 0) {
					totalPages++;
				}
				int modVal = currentPage % 5;
				startPage = currentPage / 5 * 5 + 1;
				if(modVal == 0) startPage -= 5;
				
				endPage = startPage + 4;
				if(endPage > totalPages) endPage = totalPages;
			}
		}
		
		public int getTotal() {
			return total;
		}
		
		public boolean hasNoArticles() {
			return total == 0;
		}
		
		public boolean hasArticles() {
			return total > 0;
		}
		
		public int getCurrentPage() {
			return currentPage;
		}
		
		public int getTotalPages() {
			return totalPages;
		}
		
		public List<Article> getArticle() {
			return article;
		}
		
		public int getStartPage() {
			return startPage;
		}
		
		public int getEndPage() {
			return endPage;
		}
}

