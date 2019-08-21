package com.adidas.products.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Class to represent the product.
 *
 */
@JsonSerialize
@Entity
@Table(name = "PRODUCT")
@JsonPropertyOrder({ "id", "name", "model_number", "product_type", "meta_data", "pricing_information",
        "product_description" })
public class Product implements Serializable {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("model_number")
    private String modelNumber;

    @JsonProperty("product_type")
    private String productType;

    @Lob
    @JsonProperty("meta_data")
    private MetaData metaData;

    @Lob
    @JsonProperty("pricing_information")
    private PricingInformation pricingInformation;

    @Lob
    @JsonProperty("product_description")
    private ProductDescription productDescription;

    private final static long serialVersionUID = 5630818181778103425L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Product withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("model_number")
    public String getModelNumber() {
        return modelNumber;
    }

    @JsonProperty("model_number")
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Product withModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
        return this;
    }

    @JsonProperty("product_type")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("product_type")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Product withProductType(String productType) {
        this.productType = productType;
        return this;
    }

    @JsonProperty("meta_data")
    public MetaData getMetaData() {
        return metaData;
    }

    @JsonProperty("meta_data")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Product withMetaData(MetaData metaData) {
        this.metaData = metaData;
        return this;
    }

    @JsonProperty("pricing_information")
    public PricingInformation getPricingInformation() {
        return pricingInformation;
    }

    @JsonProperty("pricing_information")
    public void setPricingInformation(PricingInformation pricingInformation) {
        this.pricingInformation = pricingInformation;
    }

    public Product withPricingInformation(PricingInformation pricingInformation) {
        this.pricingInformation = pricingInformation;
        return this;
    }

    @JsonProperty("product_description")
    public ProductDescription getProductDescription() {
        return productDescription;
    }

    @JsonProperty("product_description")
    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public Product withProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("modelNumber", modelNumber)
                .append("productType", productType).append("metaData", metaData)
                .append("pricingInformation", pricingInformation).append("productDescription", productDescription)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(productDescription).append(pricingInformation).append(name)
                .append(metaData).append(modelNumber).append(productType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return new EqualsBuilder().append(id, rhs.id).append(productDescription, rhs.productDescription)
                .append(pricingInformation, rhs.pricingInformation).append(name, rhs.name)
                .append(metaData, rhs.metaData).append(modelNumber, rhs.modelNumber)
                .append(productType, rhs.productType).isEquals();
    }

}