/**
 * Copyright (c) 2017 Contributors to the Eclipse Foundation
 * Copyright 2017 SmartBear Software
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.microprofile.openapi.models.media;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.openapi.models.Constructible;
import org.eclipse.microprofile.openapi.models.Extensible;
import org.eclipse.microprofile.openapi.models.ExternalDocumentation;
import org.eclipse.microprofile.openapi.models.Reference;

/**
 * The Schema Object allows the definition of input and output data types. These types can be objects, but also
 * primitives and arrays. This object is an extended subset of the
 * <a href="https://tools.ietf.org/html/draft-wright-json-schema-00">JSON Schema Specification Wright Draft 00</a>.
 * <p>
 * For more information about the properties, see <a href="http://json-schema.org/">JSON Schema Core</a> and
 * <a href= "https://tools.ietf.org/html/draft-wright-json-schema-validation-00">JSON Schema Validation</a>. Unless
 * stated otherwise, the property definitions follow the JSON Schema.
 * <p>
 * Any time a Schema Object can be used, a Reference Object can be used in its place. This allows referencing an
 * existing definition instead of defining the same Schema again.
 * 
 * @see <a href= "https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md#schemaObject">OpenAPI
 *      Specification Schema Object</a>
 */
public interface Schema extends Extensible<Schema>, Constructible, Reference<Schema> {

    /**
     * The values allowed for the in field.
     */
    enum SchemaType {
        INTEGER("integer"), NUMBER("number"), BOOLEAN("boolean"), STRING("string"), OBJECT("object"), ARRAY("array");

        private final String value;

        SchemaType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * Returns the discriminator property from this Schema instance.
     *
     * @return the discriminator that is used to differentiate between the schemas which may satisfy the payload
     *         description
     **/
    Discriminator getDiscriminator();

    /**
     * Sets the discriminator property of this Schema instance to the given object.
     *
     * @param discriminator
     *            the object that is used to differentiate between the schemas which may satisfy the payload description
     */
    void setDiscriminator(Discriminator discriminator);

    /**
     * Sets the discriminator property of this Schema instance to the given object.
     *
     * @param discriminator
     *            the object that is used to differentiate between the schemas which may satisfy the payload description
     * @return the current Schema instance
     */
    default Schema discriminator(Discriminator discriminator) {
        setDiscriminator(discriminator);
        return this;
    }

    /**
     * Returns the title property from this Schema instance.
     *
     * @return the title assigned to this Schema
     **/
    String getTitle();

    /**
     * Sets the title property of this Schema instance to the given string.
     *
     * @param title
     *            a title to assign to this Schema
     */
    void setTitle(String title);

    /**
     * Sets the title property of this Schema instance to the given string.
     *
     * @param title
     *            a title to assign to this Schema
     * @return the current Schema instance
     */
    default Schema title(String title) {
        setTitle(title);
        return this;
    }

    /**
     * Returns the default value property from this Schema instance.
     *
     * @return the default value object
     **/
    Object getDefaultValue();

    /**
     * Set the default value property of this Schema instance to the value given.
     *
     * @param defaultValue
     *            a value to use as the default
     */
    void setDefaultValue(Object defaultValue);

    /**
     * Set the default value property of this Schema instance to the value given.
     *
     * @param defaultValue
     *            a value to use as the default
     * @return the current Schema instance
     */
    default Schema defaultValue(Object defaultValue) {
        setDefaultValue(defaultValue);
        return this;
    }

    /**
     * Returns the enumerated list of values allowed for objects defined by this Schema.
     *
     * @return a copy List (potentially immutable) of values allowed for objects defined by this Schema
     */
    List<Object> getEnumeration();

    /**
     * Sets the enumerated list of values allowed for objects defined by this Schema.
     *
     * @param enumeration
     *            a list of values allowed
     */
    void setEnumeration(List<Object> enumeration);

    default Schema enumeration(List<Object> enumeration) {
        setEnumeration(enumeration);
        return this;
    }

    /**
     * Adds an item of the appropriate type to the enumerated list of values allowed.
     *
     * @param enumeration
     *            an object to add to the enumerated values
     * @return current Schema instance
     */
    Schema addEnumeration(Object enumeration);

    /**
     * Removes an item of the appropriate type to the enumerated list of values allowed.
     *
     * @param enumeration
     *            an object to add to the enumerated values
     */
    void removeEnumeration(Object enumeration);

    /**
     * Returns the multipleOf property from this Schema instance.
     * <p>
     * minimum: 0
     *
     * @return the positive number that restricts the value of the object
     **/
    BigDecimal getMultipleOf();

    /**
     * Sets the multipleOf property of this Schema instance to the value given.
     *
     * @param multipleOf
     *            a positive number that restricts the value of objects described by this Schema
     */
    void setMultipleOf(BigDecimal multipleOf);

    /**
     * Sets the multipleOf property of this Schema instance to the value given.
     *
     * @param multipleOf
     *            a positive number that restricts the value of objects described by this Schema
     * @return the current Schema instance
     */
    default Schema multipleOf(BigDecimal multipleOf) {
        setMultipleOf(multipleOf);
        return this;
    }

    /**
     * Returns the maximum property from this Schema instance.
     *
     * @return the maximum value of a numeric object
     **/
    BigDecimal getMaximum();

    /**
     * Sets the maximum property of this Schema instance to the value given.
     *
     * @param maximum
     *            specifies the maximum numeric value of objects defined by this Schema
     */
    void setMaximum(BigDecimal maximum);

    /**
     * Sets the maximum property of this Schema instance to the value given.
     *
     * @param maximum
     *            specifies the maximum numeric value of objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema maximum(BigDecimal maximum) {
        setMaximum(maximum);
        return this;
    }

    /**
     * Returns the exclusiveMaximum property from this Schema instance.
     *
     * @return whether the numeric value of objects must be less than the maximum property
     **/
    Boolean getExclusiveMaximum();

    /**
     * Sets the exclusiveMaximum property of this Schema instance to the value given.
     *
     * @param exclusiveMaximum
     *            when true the numeric value of objects defined by this Schema must be less than indicated by the
     *            maximum property
     */
    void setExclusiveMaximum(Boolean exclusiveMaximum);

    /**
     * Sets the exclusiveMaximum property of this Schema instance to the value given.
     *
     * @param exclusiveMaximum
     *            when true the numeric value of objects defined by this Schema must be less than indicated by the
     *            maximum property
     * @return the current Schema instance
     */
    default Schema exclusiveMaximum(Boolean exclusiveMaximum) {
        setExclusiveMaximum(exclusiveMaximum);
        return this;
    }

    /**
     * Returns the minimum property from this Schema instance.
     *
     * @return the minimum value of a numeric object
     **/
    BigDecimal getMinimum();

    /**
     * Sets the minimum property of this Schema instance to the value given.
     *
     * @param minimum
     *            specifies the minimum numeric value of objects defined by this Schema
     */
    void setMinimum(BigDecimal minimum);

    /**
     * Sets the minimum property of this Schema instance to the value given.
     *
     * @param minimum
     *            specifies the minimum numeric value of objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema minimum(BigDecimal minimum) {
        setMinimum(minimum);
        return this;
    }

    /**
     * Returns the exclusiveMinimum property from this Schema instance.
     *
     * @return whether the numeric value of objects must be greater than the minimum property
     **/
    Boolean getExclusiveMinimum();

    /**
     * Sets the exclusiveMinimum property of this Schema instance to the value given.
     *
     * @param exclusiveMinimum
     *            when true the numeric value of objects defined by this Schema must be greater than indicated by the
     *            minimum property
     */
    void setExclusiveMinimum(Boolean exclusiveMinimum);

    /**
     * Sets the exclusiveMinimum property of this Schema instance to the value given.
     *
     * @param exclusiveMinimum
     *            when true the numeric value of objects defined by this Schema must be greater than indicated by the
     *            minimum property
     * @return the current Schema instance
     */
    default Schema exclusiveMinimum(Boolean exclusiveMinimum) {
        setExclusiveMinimum(exclusiveMinimum);
        return this;
    }

    /**
     * Returns the maxLength property from this Schema instance.
     * <p>
     * minimum: 0
     *
     * @return the maximum length of objects e.g. strings
     **/
    Integer getMaxLength();

    /**
     * Sets the maxLength property of this Schema instance to the value given.
     *
     * @param maxLength
     *            the maximum length of objects defined by this Schema
     */
    void setMaxLength(Integer maxLength);

    /**
     * Sets the maxLength property of this Schema instance to the value given.
     *
     * @param maxLength
     *            the maximum length of objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema maxLength(Integer maxLength) {
        setMaxLength(maxLength);
        return this;
    }

    /**
     * Returns the minLength property from this Schema instance.
     * <p>
     * minimum: 0
     *
     * @return the minimum length of objects e.g. strings
     **/
    Integer getMinLength();

    /**
     * Sets the minLength property of this Schema instance to the value given.
     *
     * @param minLength
     *            the minimum length of objects defined by this Schema
     */
    void setMinLength(Integer minLength);

    /**
     * Sets the minLength property of this Schema instance to the value given.
     *
     * @param minLength
     *            the minimum length of objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema minLength(Integer minLength) {
        setMinLength(minLength);
        return this;
    }

    /**
     * Returns the pattern property from this Schema instance.
     *
     * @return the regular expression which restricts the value of an object e.g. a string
     **/
    String getPattern();

    /**
     * Sets the pattern property of this Schema instance to the string given.
     *
     * @param pattern
     *            the regular expression which restricts objects defined by this Schema
     */
    void setPattern(String pattern);

    /**
     * Sets the pattern property of this Schema instance to the string given.
     *
     * @param pattern
     *            the regular expression which restricts objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema pattern(String pattern) {
        setPattern(pattern);
        return this;
    }

    /**
     * Returns the maxItems property from this Schema instance.
     * <p>
     * minimum: 0
     *
     * @return the maximum number of elements in the object e.g. array elements
     **/
    Integer getMaxItems();

    /**
     * Sets the maxItems property of this Schema instance to the value given.
     *
     * @param maxItems
     *            the maximum number of elements in objects defined by this Schema e.g. array elements
     */
    void setMaxItems(Integer maxItems);

    /**
     * Sets the maxItems property of this Schema instance to the value given.
     *
     * @param maxItems
     *            the maximum number of elements in objects defined by this Schema e.g. array elements
     * @return the current Schema instance
     */
    default Schema maxItems(Integer maxItems) {
        setMaxItems(maxItems);
        return this;
    }

    /**
     * Returns the minItems property from this Schema instance.
     * <p>
     * minimum: 0
     *
     * @return the minimum number of elements in the object e.g. array elements
     **/
    Integer getMinItems();

    /**
     * Sets the minItems property of this Schema instance to the value given.
     *
     * @param minItems
     *            the minimum number of elements in objects defined by this Schema e.g. array elements
     */
    void setMinItems(Integer minItems);

    /**
     * Sets the minItems property of this Schema instance to the value given.
     *
     * @param minItems
     *            the minimum number of elements in objects defined by this Schema e.g. array elements
     * @return the current Schema instance
     */
    default Schema minItems(Integer minItems) {
        setMinItems(minItems);
        return this;
    }

    /**
     * Returns the uniqueItems property from this Schema instance.
     *
     * @return whether to ensure items are unique
     **/
    Boolean getUniqueItems();

    /**
     * Sets the uniqueItems property of this Schema instance to the value given.
     *
     * @param uniqueItems
     *            ensure the items (e.g. array elements) are unique in objects defined by this Schema
     */
    void setUniqueItems(Boolean uniqueItems);

    /**
     * Sets the uniqueItems property of this Schema instance to the value given.
     *
     * @param uniqueItems
     *            ensure the items (e.g. array elements) are unique in objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema uniqueItems(Boolean uniqueItems) {
        setUniqueItems(uniqueItems);
        return this;
    }

    /**
     * Returns the maxProperties property from this Schema instance.
     * <p>
     * minimum: 0
     *
     * @return the maximum number of properties allowed in the object
     **/
    Integer getMaxProperties();

    /**
     * Sets the maxProperties property of this Schema instance to the value given.
     *
     * @param maxProperties
     *            limit the number of properties in objects defined by this Schema
     */
    void setMaxProperties(Integer maxProperties);

    /**
     * Sets the maxProperties property of this Schema instance to the value given.
     *
     * @param maxProperties
     *            limit the number of properties in objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema maxProperties(Integer maxProperties) {
        setMaxProperties(maxProperties);
        return this;
    }

    /**
     * Returns the minProperties property from this Schema instance.
     * <p>
     * minimum: 0
     *
     * @return the minimum number of properties allowed in the object
     **/
    Integer getMinProperties();

    /**
     * Sets the minProperties property of this Schema instance to the value given.
     *
     * @param minProperties
     *            limit the number of properties in objects defined by this Schema
     */
    void setMinProperties(Integer minProperties);

    /**
     * Sets the minProperties property of this Schema instance to the value given.
     *
     * @param minProperties
     *            limit the number of properties in objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema minProperties(Integer minProperties) {
        setMinProperties(minProperties);
        return this;
    }

    /**
     * Returns the required property from this Schema instance.
     *
     * @return a copy List (potentially immutable) of fields required in objects defined by this Schema
     **/
    List<String> getRequired();

    /**
     * Sets the list of fields required in objects defined by this Schema.
     *
     * @param required
     *            the list of fields required in objects defined by this Schema
     */
    void setRequired(List<String> required);

    /**
     * Sets the list of fields required in objects defined by this Schema.
     *
     * @param required
     *            the list of fields required in objects defined by this Schema
     * @return the current Schema instance
     */
    default Schema required(List<String> required) {
        setRequired(required);
        return this;
    }

    /**
     * Adds the name of an item to the list of fields required in objects defined by this Schema.
     *
     * @param required
     *            the name of an item required in objects defined by this Schema instance
     * @return the current Schema instance
     */
    Schema addRequired(String required);

    /**
     * Removes the name of an item to the list of fields required in objects defined by this Schema.
     *
     * @param required
     *            the name of an item required in objects defined by this Schema instance
     */
    void removeRequired(String required);

    /**
     * Returns the type property from this Schema.
     *
     * @return the type used in this Schema. Default value <b>must</b> be <code>null</code>
     **/
    SchemaType getType();

    /**
     * Sets the type used by this Schema to the string given.
     *
     * @param type
     *            the type used by this Schema or <code>null</code> for reference schemas
     */
    void setType(SchemaType type);

    /**
     * Sets the type used by this Schema to the string given.
     *
     * @param type
     *            the type used by this Schema or <code>null</code> for reference schemas
     * @return the current Schema instance
     */
    default Schema type(SchemaType type) {
        setType(type);
        return this;
    }

    /**
     * Returns a Schema which describes properties not allowed in objects defined by the current schema.
     *
     * @return the not property's schema
     **/
    Schema getNot();

    /**
     * Sets the not property to a Schema which describes properties not allowed in objects defined by the current
     * schema.
     *
     * @param not
     *            the Schema which describes properties not allowed
     */
    void setNot(Schema not);

    /**
     * Sets the not property to a Schema which describes properties not allowed in objects defined by the current
     * schema.
     *
     * @param not
     *            the Schema which describes properties not allowed
     * @return the current Schema instance
     */
    default Schema not(Schema not) {
        setNot(not);
        return this;
    }

    /**
     * Returns the properties defined in this Schema.
     *
     * @return a copy Map (potentially immutable) which associates property names with the schemas that describe their
     *         contents
     **/
    Map<String, Schema> getProperties();

    /**
     * Sets the properties of this Schema instance to the map provided.
     *
     * @param properties
     *            a map which associates property names with the schemas that describe their contents
     */
    void setProperties(Map<String, Schema> properties);

    /**
     * Sets the properties of this Schema instance to the map provided.
     *
     * @param properties
     *            a map which associates property names with the schemas that describe their contents
     * @return the current Schema instance
     */
    default Schema properties(Map<String, Schema> properties) {
        setProperties(properties);
        return this;
    }

    /**
     * Adds a Schema property of the provided name using the given schema.
     *
     * @param key
     *            the name of a new Schema property
     * @param propertySchema
     *            the Schema which describes the properties of the named property. null values will be rejected
     *            (implementation will throw an exception) or ignored.
     * @return the current Schema instance
     */
    Schema addProperty(String key, Schema propertySchema);

    /**
     * Removes a Schema property of the provided name using the given schema.
     *
     * @param key
     *            the name of a new Schema property
     */
    void removeProperty(String key);

    /**
     * Returns the value of the "additionalProperties" setting, which indicates whether properties not otherwise defined
     * are allowed. This setting MUST either be a {@link Boolean} or {@link Schema}, they can not be set both at the
     * same time.
     * <p>
     * This method returns a {@link Schema}, for the {@link Boolean} getter use
     * {@link #getAdditionalPropertiesBoolean()}
     * <ul>
     * <li>If "additionalProperties" is a Schema, then additional properties are allowed but should conform to the
     * Schema.</li>
     * </ul>
     * 
     * @return this Schema's additionalProperties property (as {@link Schema})
     */
    Schema getAdditionalPropertiesSchema();

    /**
     * Returns the value of the "additionalProperties" setting, which indicates whether properties not otherwise defined
     * are allowed. This setting MUST either be a {@link Boolean} or {@link Schema}, they can not be set both at the
     * same time.
     * <p>
     * This method returns a {@link Boolean}, for the {@link Schema} getter use {@link #getAdditionalPropertiesSchema()}
     * <ul>
     * <li>If "additionalProperties" is true, then any additional properties are allowed.</li>
     *
     * <li>If "additionalProperties" is false, then only properties covered by the "properties" and "patternProperties"
     * are allowed.</li>
     * </ul>
     * 
     * @return this Schema's additionalProperties property (as {@link Boolean})
     */
    Boolean getAdditionalPropertiesBoolean();

    /**
     * Sets the Schema which defines additional properties not defined by "properties" or "patternProperties". See the
     * javadoc for {@link Schema#getAdditionalPropertiesSchema()} for more details on this setting. Note that this
     * version of the setter is mutually exclusive with the {@link Boolean} variants (see
     * {@link #setAdditionalPropertiesBoolean(Boolean)}).
     *
     * @param additionalProperties
     *            a Schema which defines additional properties
     */
    void setAdditionalPropertiesSchema(Schema additionalProperties);

    /**
     * Sets the value of "additionalProperties" to either True or False. See the javadoc for
     * {@link Schema#getAdditionalPropertiesBoolean()} for more details on this setting. Note that this version of the
     * setter is mutually exclusive with the {@link Schema} variants (see
     * {@link #setAdditionalPropertiesSchema(Schema)}).
     *
     * @param additionalProperties
     *            a Schema which defines additional properties
     */
    void setAdditionalPropertiesBoolean(Boolean additionalProperties);

    /**
     * Sets the Schema which defines additional properties not defined by "properties" or "patternProperties". See the
     * javadoc for {@link Schema#getAdditionalPropertiesSchema()} for more details on this setting. Note that this
     * version of the setter is mutually exclusive with the {@link Boolean} variants (see
     * {@link #additionalPropertiesBoolean(Boolean)}).
     *
     * @param additionalProperties
     *            a Schema which defines additional properties
     * @return the current Schema instance
     */
    default Schema additionalPropertiesSchema(Schema additionalProperties) {
        setAdditionalPropertiesSchema(additionalProperties);
        return this;
    }

    /**
     * Sets the value of "additionalProperties" to either True or False. See the javadoc for
     * {@link Schema#getAdditionalPropertiesBoolean()} for more details on this setting. Note that this version of the
     * setter is mutually exclusive with the {@link Schema} variants (see {@link #additionalPropertiesSchema(Schema)}).
     *
     * @param additionalProperties
     *            a Schema which defines additional properties
     * @return the current Schema instance
     */
    default Schema additionalPropertiesBoolean(Boolean additionalProperties) {
        setAdditionalPropertiesBoolean(additionalProperties);
        return this;
    }

    /**
     * Returns a description of the purpose of this Schema.
     *
     * @return a string containing a description
     **/
    String getDescription();

    /**
     * Sets the description property of this Schema to the given string.
     *
     * @param description
     *            a string containing a description of the purpose of this Schema
     */
    void setDescription(String description);

    /**
     * Sets the description property of this Schema to the given string.
     *
     * @param description
     *            a string containing a description of the purpose of this Schema
     * @return the current Schema instance
     */
    default Schema description(String description) {
        setDescription(description);
        return this;
    }

    /**
     * Returns the format property from this Schema instance. This property clarifies the data type specified in the
     * type property.
     *
     * @return a string describing the format of the data in this Schema
     **/
    String getFormat();

    /**
     * Sets the format property of this Schema instance to the given string. The value may be one of the formats
     * described in the OAS or a user defined format.
     *
     * @param format
     *            the string specifying the data format
     */
    void setFormat(String format);

    /**
     * Sets the format property of this Schema instance to the given string. The value may be one of the formats
     * described in the OAS or a user defined format.
     *
     * @param format
     *            the string specifying the data format
     * @return the current Schema instance
     */
    default Schema format(String format) {
        setFormat(format);
        return this;
    }

    /**
     * Returns the nullable property from this Schema instance which indicates whether null is a valid value.
     *
     * @return the nullable property
     **/
    Boolean getNullable();

    /**
     * Sets the nullable property of this Schema instance. Specify true if this Schema will allow null values.
     *
     * @param nullable
     *            a boolean value indicating this Schema allows a null value.
     */
    void setNullable(Boolean nullable);

    /**
     * Sets the nullable property of this Schema instance. Specify true if this Schema will allow null values.
     *
     * @param nullable
     *            a boolean value indicating this Schema allows a null value.
     * @return the current Schema instance
     */
    default Schema nullable(Boolean nullable) {
        setNullable(nullable);
        return this;
    }

    /**
     * Returns the readOnly property from this Schema instance.
     *
     * @return indication that the Schema is only valid in a response message
     **/
    Boolean getReadOnly();

    /**
     * Sets the readOnly property of this Schema. Only valid when the Schema is the property in an object.
     *
     * @param readOnly
     *            true indicates the Schema should not be sent as part of a request message
     */
    void setReadOnly(Boolean readOnly);

    /**
     * Sets the readOnly property of this Schema. Only valid when the Schema is the property in an object.
     *
     * @param readOnly
     *            true indicates the Schema should not be sent as part of a request message
     * @return the current Schema instance
     */
    default Schema readOnly(Boolean readOnly) {
        setReadOnly(readOnly);
        return this;
    }

    /**
     * Returns the writeOnly property from this Schema instance.
     *
     * @return indication that the Schema is only valid in a request message
     **/
    Boolean getWriteOnly();

    /**
     * Sets the writeOnly property of this Schema. Only valid when the Schema is the property in an object.
     *
     * @param writeOnly
     *            true indicates the Schema should not be sent as part of a response message
     */
    void setWriteOnly(Boolean writeOnly);

    /**
     * Sets the writeOnly property of this Schema. Only valid when the Schema is the property in an object.
     *
     * @param writeOnly
     *            true indicates the Schema should not be sent as part of a response message
     * @return the current Schema instance
     */
    default Schema writeOnly(Boolean writeOnly) {
        setWriteOnly(writeOnly);
        return this;
    }

    /**
     * Returns the example property from this Schema instance.
     *
     * @return an object which is an example of an instance of this Schema
     **/
    Object getExample();

    /**
     * Sets the example property of this Schema instance. To represent examples that cannot be naturally represented in
     * JSON or YAML, a string value can be used to contain the example with escaping where necessary.
     *
     * @param example
     *            an object which is an instance of this Schema
     */
    void setExample(Object example);

    /**
     * Sets the example property of this Schema instance. To represent examples that cannot be naturally represented in
     * JSON or YAML, a string value can be used to contain the example with escaping where necessary.
     *
     * @param example
     *            an object which is an instance of this Schema
     * @return the current Schema instance
     */
    default Schema example(Object example) {
        setExample(example);
        return this;
    }

    /**
     * Returns the externalDocs property from this Schema instance.
     *
     * @return additional external documentation for this Schema
     **/
    ExternalDocumentation getExternalDocs();

    /**
     * Sets the externalDocs property of this Schema to the indicated value.
     *
     * @param externalDocs
     *            an additional external documentation object
     */
    void setExternalDocs(ExternalDocumentation externalDocs);

    /**
     * Sets the externalDocs property of this Schema to the indicated value.
     *
     * @param externalDocs
     *            an additional external documentation object
     * @return the current Schema instance
     */
    default Schema externalDocs(ExternalDocumentation externalDocs) {
        setExternalDocs(externalDocs);
        return this;
    }

    /**
     * Returns the deprecated property from this Schema instance.
     *
     * @return indication that the Schema is deprecated and should be transitioned out of usage
     **/
    Boolean getDeprecated();

    /**
     * Sets the deprecated property of this Schema. This specifies that the Schema is deprecated and should be
     * transitioned out of usage
     *
     * @param deprecated
     *            true to indicate this Schema is deprecated
     */
    void setDeprecated(Boolean deprecated);

    /**
     * Sets the deprecated property of this Schema. This specifies that the Schema is deprecated and should be
     * transitioned out of usage
     *
     * @param deprecated
     *            true to indicate this Schema is deprecated
     * @return the current Schema instance
     */
    default Schema deprecated(Boolean deprecated) {
        setDeprecated(deprecated);
        return this;
    }

    /**
     * Returns the xml property from this Schema instance.
     *
     * @return a metadata object that allows for more fine-tuned XML model definitions
     **/
    XML getXml();

    /**
     * Sets the xml property of this Schema instance. It may only be set on properties schemas and adds additional
     * metadata to describe the XML representation of this property.
     *
     * @param xml
     *            a metadata object to describe the XML representation of this property
     */
    void setXml(XML xml);

    /**
     * Sets the xml property of this Schema instance. It may only be set on properties schemas and adds additional
     * metadata to describe the XML representation of this property.
     *
     * @param xml
     *            a metadata object to describe the XML representation of this property
     * @return the current Schema instance
     */
    default Schema xml(XML xml) {
        setXml(xml);
        return this;
    }

    /**
     * Returns the Schema used for all the elements of an array typed Schema.
     *
     * @return the Schema used for all the elements
     **/
    Schema getItems();

    /**
     * Set the Schema used for all the elements of an array typed Schema.
     *
     * @param items
     *            the Schema used by this array
     */
    void setItems(Schema items);

    /**
     * Set the Schema used for all the elements of an array typed Schema.
     *
     * @param items
     *            the Schema used by this array
     * @return the current Schema instance
     */
    default Schema items(Schema items) {
        setItems(items);
        return this;
    }

    /**
     * Returns the schemas used by the allOf property.
     *
     * @return a copy List (potentially immutable) of schemas used by the allOf property
     **/
    List<Schema> getAllOf();

    /**
     * Sets the schemas used by the allOf property of this Schema.
     * 
     * @param allOf
     *            the list of schemas used by the allOf property
     */
    void setAllOf(List<Schema> allOf);

    /**
     * Sets the schemas used by the allOf property of this Schema.
     * 
     * @param allOf
     *            the list of schemas used by the allOf property
     * @return the current Schema instance
     */
    default Schema allOf(List<Schema> allOf) {
        setAllOf(allOf);
        return this;
    }

    /**
     * Adds the given Schema to the list of schemas used by the allOf property.
     * 
     * @param allOf
     *            a Schema to use with the allOf property
     * @return the current Schema instance
     */
    Schema addAllOf(Schema allOf);

    /**
     * Removes the given Schema to the list of schemas used by the allOf property.
     * 
     * @param allOf
     *            a Schema to use with the allOf property
     */
    void removeAllOf(Schema allOf);

    /**
     * Returns the schemas used by the anyOf property.
     *
     * @return a copy List (potentially immutable) of schemas used by the anyOf property
     **/
    List<Schema> getAnyOf();

    /**
     * Sets the schemas used by the anyOf property of this Schema.
     * 
     * @param anyOf
     *            the list of schemas used by the anyOf property
     */
    void setAnyOf(List<Schema> anyOf);

    /**
     * Sets the schemas used by the anyOf property of this Schema.
     * 
     * @param anyOf
     *            the list of schemas used by the anyOf property
     * @return the current Schema instance
     */
    default Schema anyOf(List<Schema> anyOf) {
        setAnyOf(anyOf);
        return this;
    }

    /**
     * Adds the given Schema to the list of schemas used by the anyOf property.
     * 
     * @param anyOf
     *            a Schema to use with the anyOf property
     * @return the current Schema instance
     */
    Schema addAnyOf(Schema anyOf);

    /**
     * Removes the given Schema to the list of schemas used by the anyOf property.
     * 
     * @param anyOf
     *            a Schema to use with the anyOf property
     */
    void removeAnyOf(Schema anyOf);

    /**
     * Returns the schemas used by the oneOf property.
     *
     * @return a copy List (potentially immutable) of schemas used by the oneOf property
     **/
    List<Schema> getOneOf();

    /**
     * Sets the schemas used by the oneOf property of this Schema.
     * 
     * @param oneOf
     *            the list of schemas used by the oneOf property
     */
    void setOneOf(List<Schema> oneOf);

    /**
     * Sets the schemas used by the oneOf property of this Schema.
     * 
     * @param oneOf
     *            the list of schemas used by the oneOf property
     * @return the current Schema instance
     */
    default Schema oneOf(List<Schema> oneOf) {
        setOneOf(oneOf);
        return this;
    }

    /**
     * Adds the given Schema to the list of schemas used by the oneOf property.
     * 
     * @param oneOf
     *            a Schema to use with the oneOf property
     * @return the current Schema instance
     */
    Schema addOneOf(Schema oneOf);

    /**
     * Removes the given Schema to the list of schemas used by the oneOf property.
     * 
     * @param oneOf
     *            a Schema to use with the oneOf property
     */
    void removeOneOf(Schema oneOf);

}
