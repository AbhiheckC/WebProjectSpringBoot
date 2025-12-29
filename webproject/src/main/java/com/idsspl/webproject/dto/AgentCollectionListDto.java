package com.idsspl.webproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.idsspl.webproject.model.AgentCollectionModel;

public class AgentCollectionListDto {

	 private List<AgentCollectionModel> agentCollectionList;

		public AgentCollectionListDto() {
			super();
			this.agentCollectionList = new ArrayList<>();
		}

		public List<AgentCollectionModel> getAgentCollectionList() {
			return agentCollectionList;
		}

		public void setAgentCollectionList(List<AgentCollectionModel> agentCollectionList) {
			this.agentCollectionList = agentCollectionList;
		}

		public void setAgentCollectionModelList(List<AgentCollectionModel> agentCollectionModelList) {
			this.agentCollectionList = agentCollectionModelList;
		}

		public void addAgentCollection(AgentCollectionModel model) {
	        this.agentCollectionList.add(model);
	    }
	
}
