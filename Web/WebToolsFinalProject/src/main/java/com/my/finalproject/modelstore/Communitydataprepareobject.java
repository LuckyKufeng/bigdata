package com.my.finalproject.modelstore;

import java.util.ArrayList;

import com.my.finalproject.model.FileTable;


public class Communitydataprepareobject {
		
		private ArrayList<FileTable> filetables;
		private String name;
		private ArrayList<String> dates;
		
		public Communitydataprepareobject(){
			this.filetables = new ArrayList<FileTable>();
			this.dates = new ArrayList<String>();
		}
		
		public ArrayList<FileTable> getFiletables() {
			return filetables;
		}
		public void setFiletables(ArrayList<FileTable> filetables) {
			this.filetables = filetables;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public ArrayList<String> getDates() {
			return dates;
		}

		public void setDates(ArrayList<String> dates) {
			this.dates = dates;
		}
		
		
		
		
	
}
