/**
 * 
 */
package de.terrestris.shogun2.model.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A LayerTree is a simple module, where layers (of a map) are organized in a
 * flexible tree structure.
 * 
 * @author Nils Bühner
 *
 */
@Entity
@Table
public class NominatimSearch extends Module {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Explicitly adding the default constructor as this is important, e.g. for
	 * Hibernate: http://goo.gl/3Cr1pw
	 */
	public NominatimSearch() {
	}
	
	/**
	 * 
	 * A enum type for the allowed response format.
	 */
	public enum nominatimFormatType {
		html,xml,json,jsonv2;
	}
	
	/**
	 * The response format.
	 */
	@Enumerated(EnumType.STRING)
	private nominatimFormatType format;
	
	/**
	 * Limits the response.
	 */
	private Integer limit;
	
	/**
	 * A list of EPSG-Codes the should be available in the module.
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Nominatim_viewboxlbrt", joinColumns = @JoinColumn(name = "Nominatim_ID") )
	@Column(name = "viewboxInteger")
	@OrderColumn(name = "INDEX")
	private List<Integer> viewboxlbrt = new ArrayList<Integer>();

	/**
	 * Characters needed to send a request.
	 */
	private Integer minSearchTextChars;
	
	/**
	 * The delay between hitting a key and sending the request in ms.
	 */
	private Integer typeDelay;
	
	/**
	 * The template of the grouping Header.
	 * See: http://docs.sencha.com/extjs/6.0/6.0.0-classic/#!/api/Ext.grid.feature.Grouping-cfg-groupHeaderTpl
	 */
	private String groupHeaderTpl;
	
	/**
	 * @return the format
	 */
	public nominatimFormatType getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(nominatimFormatType format) {
		this.format = format;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the viewboxlbrt
	 */
	public List<Integer> getViewboxlbrt() {
		return viewboxlbrt;
	}

	/**
	 * @param viewboxlbrt the viewboxlbrt to set
	 */
	public void setViewboxlbrt(List<Integer> viewboxlbrt) {
		this.viewboxlbrt = viewboxlbrt;
	}

	/**
	 * @return the minSearchTextChars
	 */
	public Integer getMinSearchTextChars() {
		return minSearchTextChars;
	}

	/**
	 * @param minSearchTextChars the minSearchTextChars to set
	 */
	public void setMinSearchTextChars(Integer minSearchTextChars) {
		this.minSearchTextChars = minSearchTextChars;
	}

	/**
	 * @return the typeDelay
	 */
	public Integer getTypeDelay() {
		return typeDelay;
	}

	/**
	 * @param typeDelay the typeDelay to set
	 */
	public void setTypeDelay(Integer typeDelay) {
		this.typeDelay = typeDelay;
	}

	/**
	 * @return the groupHeaderTpl
	 */
	public String getGroupHeaderTpl() {
		return groupHeaderTpl;
	}

	/**
	 * @param groupHeaderTpl the groupHeaderTpl to set
	 */
	public void setGroupHeaderTpl(String groupHeaderTpl) {
		this.groupHeaderTpl = groupHeaderTpl;
	}

	
	/**
	 * @see java.lang.Object#hashCode()
	 *
	 *      According to
	 *      http://stackoverflow.com/questions/27581/overriding-equals
	 *      -and-hashcode-in-java it is recommended only to use getter-methods
	 *      when using ORM like Hibernate
	 */
	public int hashCode() {
		// two randomly chosen prime numbers
		return new HashCodeBuilder(29, 3).appendSuper(super.hashCode()).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 *
	 *      According to
	 *      http://stackoverflow.com/questions/27581/overriding-equals
	 *      -and-hashcode-in-java it is recommended only to use getter-methods
	 *      when using ORM like Hibernate
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof NominatimSearch))
			return false;
		NominatimSearch other = (NominatimSearch) obj;

		return new EqualsBuilder().appendSuper(super.equals(other)).isEquals();
	}

	/**
	 *
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).appendSuper(super.toString()).toString();
	}

}