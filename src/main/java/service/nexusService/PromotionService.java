package service.nexusService;

import java.util.List;

import dao.nexusDao.PromotionDAO;
import model.Promotion;

public class PromotionService {
	

		PromotionDAO dao=new PromotionDAO();
		
		public void savePromotion(Promotion P)
		{
			dao.savePromotion(P);
		}
		
		public List<Promotion> fetchPromotions()
		{
			return dao.fetchPromotions();
		}
		public void delPromotion(int id)
		{
			dao.delPromotion(id);
		}
		
		public Promotion findById(int id)
		{
			return dao.findById(id);
		}
		
		public void UpdatePromotion(Promotion p)
		{
			dao.UpdatePromotion(p);
		}

}
