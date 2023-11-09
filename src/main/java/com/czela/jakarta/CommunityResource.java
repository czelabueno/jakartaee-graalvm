package com.czela.jakarta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("community")
public class CommunityResource {
	
	private Community community;

	public CommunityResource() {
		this.community = new Community(
				"Eclipse Foundation",
				List.of("Fabio","Eudris", "Carlos")
		);

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Community community() {
		return this.community;
	}

	@PUT
	@Path("/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Community addMember(@PathParam("name") String name) {
		List<String> members = new ArrayList<>(this.community.getMembers());
		members.add(name);
		return new Community(this.community.getName(),members);
	}

	@DELETE
	@Path("/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Community removeMember(@PathParam("name") String name) {
		List<String> members = new ArrayList<>(this.community.getMembers());
		members.removeIf(n -> n.equals(name));
		return new Community(this.community.getName(),members);
	}
}
