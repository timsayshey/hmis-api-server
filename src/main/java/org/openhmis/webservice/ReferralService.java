



package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.openhmis.dto.ReferralDTO;
import org.openhmis.dto.search.ReferralSearchDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.ReferralManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/referrals")
public class ReferralService {
	private static final Logger log = Logger.getLogger(ReferralService.class);
	public ReferralService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ReferralDTO> getReferrals(@HeaderParam("Authorization") String authorization, @BeanParam ReferralSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
		// If the user specified no updatedSince parameter, return everything
                List<ReferralDTO> referralDTOs = ReferralManager.getReferrals(searchDTO);
                return referralDTOs;
				
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ReferralDTO createReferral(@HeaderParam("Authorization") String authorization, ReferralDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ReferralDTO outputDTO = ReferralManager.addReferral(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{referralId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ReferralDTO getReferral(@HeaderParam("Authorization") String authorization, @PathParam("referralId") String referralId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		ReferralDTO outputDTO = ReferralManager.getReferralById(referralId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{referralId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ReferralDTO updateReferral(@HeaderParam("Authorization") String authorization, @PathParam("referralId") String referralId, ReferralDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setReferralId(referralId);
		
		ReferralDTO outputDTO = ReferralManager.updateReferral(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{referralId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteReferral(@HeaderParam("Authorization") String authorization, @PathParam("referralId") String referralId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ReferralManager.deleteReferral(referralId);
		return "true";
	}
}
