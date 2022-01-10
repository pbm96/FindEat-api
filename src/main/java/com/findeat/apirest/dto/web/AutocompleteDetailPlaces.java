package com.findeat.apirest.dto.web;

import java.io.Serializable;
import java.util.ArrayList;

public class AutocompleteDetailPlaces implements Serializable {

	/**
	 * 
	 */
	public class MatchedSubstring {
		public int length;
		public int offset;
	}

	public class MainTextMatchedSubstring {
		public int length;
		public int offset;

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public int getOffset() {
			return offset;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}

	}

	public class StructuredFormatting {
		public String main_text;
		public ArrayList<MainTextMatchedSubstring> main_text_matched_substrings;
		public String secondary_text;

		public String getMain_text() {
			return main_text;
		}

		public void setMain_text(String main_text) {
			this.main_text = main_text;
		}

		public ArrayList<MainTextMatchedSubstring> getMain_text_matched_substrings() {
			return main_text_matched_substrings;
		}

		public void setMain_text_matched_substrings(ArrayList<MainTextMatchedSubstring> main_text_matched_substrings) {
			this.main_text_matched_substrings = main_text_matched_substrings;
		}

		public String getSecondary_text() {
			return secondary_text;
		}

		public void setSecondary_text(String secondary_text) {
			this.secondary_text = secondary_text;
		}

	}

	public class Term {
		public int offset;
		public String value;

		public int getOffset() {
			return offset;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public class Prediction {
		public String description;
		public ArrayList<MatchedSubstring> matched_substrings;
		public String place_id;
		public String reference;
		public StructuredFormatting structured_formatting;
		public ArrayList<Term> terms;
		public ArrayList<String> types;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public ArrayList<MatchedSubstring> getMatched_substrings() {
			return matched_substrings;
		}

		public void setMatched_substrings(ArrayList<MatchedSubstring> matched_substrings) {
			this.matched_substrings = matched_substrings;
		}

		public String getPlace_id() {
			return place_id;
		}

		public void setPlace_id(String place_id) {
			this.place_id = place_id;
		}

		public String getReference() {
			return reference;
		}

		public void setReference(String reference) {
			this.reference = reference;
		}

		public StructuredFormatting getStructured_formatting() {
			return structured_formatting;
		}

		public void setStructured_formatting(StructuredFormatting structured_formatting) {
			this.structured_formatting = structured_formatting;
		}

		public ArrayList<Term> getTerms() {
			return terms;
		}

		public void setTerms(ArrayList<Term> terms) {
			this.terms = terms;
		}

		public ArrayList<String> getTypes() {
			return types;
		}

		public void setTypes(ArrayList<String> types) {
			this.types = types;
		}

	}

	public class Root {
		public ArrayList<Prediction> predictions;
		public String status;

	}

	private static final long serialVersionUID = -7544150241711196337L;

}
