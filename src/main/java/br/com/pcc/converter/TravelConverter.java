package br.com.pcc.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pcc.dto.TravelDto;
import br.com.pcc.entity.CommentsEntity;
import br.com.pcc.entity.PhotosEntity;
import br.com.pcc.entity.TravelEntity;

public final class TravelConverter {

	public static TravelEntity travelDtoToTravelEntity(TravelDto dto) {
		
		Date startDate = dto.getDays()[0];
		Date endDate = dto.getDays()[dto.getDays().length - 1];
		
		TravelEntity entity = new TravelEntity();
		entity.setDestination(dto.getDestination());
		entity.setStartDate(startDate);
		entity.setEndDate(endDate);
		
		List<CommentsEntity> comments = convertArrayToCommentsEntity(entity, dto.getComments(), dto.getDays());
		entity.setComments(comments);
		
		List<PhotosEntity> photos = convertArrayToPhotosEntity(entity, dto.getResources());
		entity.setComments(comments);
		entity.setPhotos(photos);
		
		entity.setRank(5d); //TODO: CORRIGIR PARA VIR DO FRONT-END RANK
		
		return entity;
	}

	private static List<CommentsEntity> convertArrayToCommentsEntity(TravelEntity travel, String[] comments, Date[] days) {
		
		List<CommentsEntity> commentsList = new ArrayList<CommentsEntity>();
		CommentsEntity comment = null;
		for (int i = 0; i < comments.length; i++) {
			commentsList.add(i, comment = new CommentsEntity(comments[i], days[i]));
			comment.setTravel(travel);
		}
		
		return commentsList;
	}
	
	private static List<PhotosEntity> convertArrayToPhotosEntity(TravelEntity travel, String[] resources) { 
		
		List<PhotosEntity> photosList = new ArrayList<PhotosEntity>();
		PhotosEntity photo = null;
		for (int i = 0; i < resources.length; i++) {
			photosList.add(i, photo = new PhotosEntity(resources[i], false)); //TODO: VERIFICAR O QUE FAZER COM photoCover
			photo.setTravel(travel);
		}
		
		return photosList;
	}
}