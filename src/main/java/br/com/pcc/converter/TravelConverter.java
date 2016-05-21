package br.com.pcc.converter;

import java.util.List;

import br.com.pcc.dto.TravelDto;
import br.com.pcc.entity.CommentsEntity;
import br.com.pcc.entity.TravelEntity;

public final class TravelConverter {

	public static TravelEntity travelDtoToTravelEntity(TravelDto dto) {
		
		TravelEntity entity = new TravelEntity();
		entity.setDestination(dto.getDestination());
		entity.setStartDate(dto.getDays()[0]);
		entity.setEndDate(dto.getDays()[dto.getDays().length - 1]);
		
		List<CommentsEntity> comments = convertArrayToCommentsEntity(dto.getComments());
		entity.setComments(comments);
		
		return entity;
	}

	private static List<CommentsEntity> convertArrayToCommentsEntity(String[] comments) {
		
		return null;
	}
}