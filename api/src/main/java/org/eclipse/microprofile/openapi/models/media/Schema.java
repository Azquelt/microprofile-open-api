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

import org.eclipse.microprofile.openapi.OASFactory;
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
        INTEGER("integer"), NUMBER("number"), BOOLEAN("boolean"), STRING("string"), OBJECT("object"), ARRAY(
                "array"), NULL("null");

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
     * @return the value that a numeric object must be less than or equal to
     **/
    BigDecimal getMaximum();

    /**
     * Sets the maximum property of this Schema instance to the value given.
     *
     * @param maximum
     *            the value that a numeric object must be less than or equal to
     */
    void setMaximum(BigDecimal maximum);

    /**
     * Sets the maximum property of this Schema instance to the value given.
     *
     * @param maximum
     *            the value that a numeric object must be less than or equal to
     * @return the current Schema instance
     */
    default Schema maximum(BigDecimal maximum) {
        setMaximum(maximum);
        return this;
    }

    /**
     * Returns the exclusiveMaximum property from this Schema instance.
     *
     * @return the value that a numeric object must be less than
     * @since 4.0
     */
    BigDecimal getExclusiveMaximum();

    /**
     * Sets the exclusiveMaximum property of this Schema instance to the value given.
     *
     * @param exclusiveMaximum
     *            the value that a numeric object must be less than
     * @since 4.0
     */
    void setExclusiveMaximum(BigDecimal exclusiveMaximum);

    /**
     * Sets the exclusiveMaximum property of this Schema instance to the value given.
     *
     * @param exclusiveMaximum
     *            the value that a numeric object must be less than
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema exclusiveMaximum(BigDecimal exclusiveMaximum) {
        setExclusiveMaximum(exclusiveMaximum);
        return this;
    }

    /**
     * Returns the minimum property from this Schema instance.
     *
     * @return the value that a numeric object must be greater than or equal to
     **/
    BigDecimal getMinimum();

    /**
     * Sets the minimum property of this Schema instance to the value given.
     *
     * @param minimum
     *            the value that a numeric object must be greater than or equal to
     */
    void setMinimum(BigDecimal minimum);

    /**
     * Sets the minimum property of this Schema instance to the value given.
     *
     * @param minimum
     *            the value that a numeric object must be greater than or equal to
     * @return the current Schema instance
     */
    default Schema minimum(BigDecimal minimum) {
        setMinimum(minimum);
        return this;
    }

    /**
     * Returns the exclusiveMinimum property from this Schema instance.
     *
     * @return the value that a numeric object must be greater than
     * @since 4.0
     */
    BigDecimal getExclusiveMinimum();

    /**
     * Sets the exclusiveMinimum property of this Schema instance to the value given.
     *
     * @param exclusiveMinimum
     *            the value that a numeric object must be greater than
     * @since 4.0
     */
    void setExclusiveMinimum(BigDecimal exclusiveMinimum);

    /**
     * Sets the exclusiveMinimum property of this Schema instance to the value given.
     *
     * @param exclusiveMinimum
     *            the value that a numeric object must be greater than
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema exclusiveMinimum(BigDecimal exclusiveMinimum) {
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
     * Returns the type property of this Schema instance. Defines the types which are valid.
     *
     * @return a copy List (potentially immutable) of the allowed types
     */
    List<SchemaType> getType();

    /**
     * Sets the type property of this Schema instance. Defines the types which are valid.
     *
     * @param types
     *            a list of the allowed types
     */
    void setType(List<SchemaType> types);

    /**
     * Sets the type property of this Schema instance. Defines the types which are valid.
     *
     * @param types
     *            a list of the allowed types
     * @return current Schema instance
     * @since "4.0"
     */
    default Schema type(List<SchemaType> types) {
        setType(types);
        return this;
    }

    /**
     * Adds a type to the type list.
     *
     * @param type
     *            the type to add to the type list
     * @return current Schema instance
     * @since "4.0"
     */
    Schema addType(SchemaType type);

    /**
     * Removes a type from the type list.
     *
     * @param type
     *            the type to remove from the type list
     * @since "4.0"
     */
    void removeType(SchemaType type);

    /**
     * Sets the type property of this Schema instance to a single type.
     *
     * @param type
     *            the required type
     * @since "4.0"
     * @deprecated use {@link #setType(List)}
     */
    @Deprecated(since = "4.0")
    void setType(SchemaType type);

    /**
     * Sets the type property of this Schema instance to a single type.
     *
     * @param type
     *            the required type
     * @return the current Schema instance
     * @deprecated use {@link #setType(List)}
     */
    @Deprecated(since = "4.0")
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
     * @deprecated use {@link #getAdditionalPropertiesSchema()} which may return a boolean-valued schema
     */
    @Deprecated(since = "4.0")
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
     * @deprecated use {@link #setAdditionalPropertiesSchema(Schema)} with a boolean-valued schema
     */
    @Deprecated(since = "4.0")
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
     * @deprecated use {@link #additionalPropertiesSchema(Schema)} with a boolean-valued schema
     */
    @Deprecated(since = "4.0")
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
     * Returns whether the type property allows the object to be {@code null}
     *
     * @return whether null is allowed
     * @deprecated use {@link #getType()} and check if the result contains {@link SchemaType#NULL}
     */
    @Deprecated(since = "4.0")
    Boolean getNullable();

    /**
     * Updates the type property to either permit or disallow {@code null}
     *
     * @param nullable
     *            a boolean value indicating whether this Schema allows a null value.
     * @deprecated use {@link #setType(List)}, {@link #addType(SchemaType)}, or {@link #removeType(SchemaType)} to add
     *             or remove {@link SchemaType#NULL}
     */
    @Deprecated(since = "4.0")
    void setNullable(Boolean nullable);

    /**
     * Sets the nullable property of this Schema instance. Specify true if this Schema will allow null values.
     *
     * @param nullable
     *            a boolean value indicating this Schema allows a null value.
     * @return the current Schema instance
     * @deprecated use {@link #setType(List)}, {@link #addType(SchemaType)}, or {@link #removeType(SchemaType)} to add
     *             or remove {@link SchemaType#NULL}
     */
    @Deprecated(since = "4.0")
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
     * Sets the readOnly property of this Schema.
     *
     * @param readOnly
     *            {@code true} indicates the Schema should not be sent as part of a request message
     */
    void setReadOnly(Boolean readOnly);

    /**
     * Sets the readOnly property of this Schema.
     *
     * @param readOnly
     *            {@code true} indicates the Schema should not be sent as part of a request message
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
     * Sets the writeOnly property of this Schema.
     *
     * @param writeOnly
     *            {@code true} indicates the Schema should not be sent as part of a response message
     */
    void setWriteOnly(Boolean writeOnly);

    /**
     * Sets the writeOnly property of this Schema.
     *
     * @param writeOnly
     *            {@code true} indicates the Schema should not be sent as part of a response message
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
     * @deprecated use {@link #getExamples()}
     */
    @Deprecated(since = "4.0")
    Object getExample();

    /**
     * Sets the example property of this Schema instance. To represent examples that cannot be naturally represented in
     * JSON or YAML, a string value can be used to contain the example with escaping where necessary.
     *
     * @param example
     *            an object which is an instance of this Schema
     * @deprecated use {@link #setExamples(List)}
     */
    @Deprecated(since = "4.0")
    void setExample(Object example);

    /**
     * Sets the example property of this Schema instance. To represent examples that cannot be naturally represented in
     * JSON or YAML, a string value can be used to contain the example with escaping where necessary.
     *
     * @param example
     *            an object which is an instance of this Schema
     * @return the current Schema instance
     * @deprecated use {@link #examples(List)}
     */
    @Deprecated(since = "4.0")
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

    /**
     * Returns the schema dialect in use. This is the value of the {@code $schema} property.
     *
     * @return the schema dialect name, or {@code null} for the default
     * @since 4.0
     */
    String getSchemaDialect();

    /**
     * Sets the schema dialect in use. This is the value of the {@code $schema} property.
     *
     * @param schemaDialect
     *            the schema dialect name, or {@code null} for the default
     * @since 4.0
     */
    void setSchemaDialect(String schemaDialect);

    /**
     * Sets the schema dialect in use. This is the value of the {@code $schema} property.
     *
     * @param schemaDialect
     *            the schema dialect name, or {@code null} for the default
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema schemaDialect(String schemaDialect) {
        setSchemaDialect(schemaDialect);
        return this;
    }

    /**
     * Returns the comment to be included in the {@code $comment} property of the schema.
     *
     * @return the comment, or {@code null} if no comment is set
     * @since 4.0
     */
    String getComment();

    /**
     * Sets the comment to be included in the {@code $comment} property of the schema.
     *
     * @param comment
     *            the comment, or {@code null} to remove any comment
     * @since 4.0
     */
    void setComment(String comment);

    /**
     * Sets the comment to be included in the {@code $comment} property of the schema.
     *
     * @param comment
     *            the comment, or {@code null} to remove any comment
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema comment(String comment) {
        setComment(comment);
        return this;
    }

    /**
     * Returns the "if" schema. If an object is valid against the "if" schema, then it must also be valid against the
     * "then" schema, otherwise it must be valid against the "else" schema.
     *
     * @return the if schema
     * @since 4.0
     */
    Schema getIfSchema();

    /**
     * Sets the "if" schema. If an object is valid against the "if" schema, then it must also be valid against the
     * "then" schema, otherwise it must be valid against the "else" schema.
     *
     * @param ifSchema
     *            the if schema
     * @since 4.0
     */
    void setIfSchema(Schema ifSchema);

    /**
     * Sets the "if" schema. If an object is valid against the "if" schema, then it must also be valid against the
     * "then" schema, otherwise it must be valid against the "else" schema.
     *
     * @param ifSchema
     *            the if schema
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema ifSchema(Schema ifSchema) {
        setIfSchema(ifSchema);
        return this;
    }

    /**
     * Returns the "then" schema. If an object is valid against the "if" schema, then it must also be valid against the
     * "then" schema.
     *
     * @return the then schema
     * @since 4.0
     */
    Schema getThenSchema();

    /**
     * Sets the "then" schema. If an object is valid against the "if" schema, then it must also be valid against the
     * "then" schema.
     *
     * @param thenSchema
     *            the then schema
     * @since 4.0
     */
    void setThenSchema(Schema thenSchema);

    /**
     * Sets the "then" schema. If an object is valid against the "if" schema, then it must also be valid against the
     * "then" schema.
     *
     * @param thenSchema
     *            the then schema
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema thenSchema(Schema thenSchema) {
        setThenSchema(thenSchema);
        return this;
    }

    /**
     * Returns the "else" schema. If an object is not valid against the "if" schema, then it must be valid against the
     * "else" schema.
     *
     * @return the else schema
     * @since 4.0
     */
    Schema getElseSchema();

    /**
     * Sets the "else" schema. If an object is not valid against the "if" schema, then it must be valid against the
     * "else" schema.
     *
     * @param elseSchema
     *            the else schema
     * @since 4.0
     */
    void setElseSchema(Schema elseSchema);

    /**
     * Sets the "else" schema. If an object is not valid against the "if" schema, then it must be valid against the
     * "else" schema.
     *
     * @param elseSchema
     *            the else schema
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema elseSchema(Schema elseSchema) {
        setElseSchema(elseSchema);
        return this;
    }

    /**
     * Returns the dependentSchemas property of this Schema instance.
     * <p>
     * For each name and property pair in the map, if the object contains a property with the given name, it must match
     * the corresponding schema.
     *
     * @return a copy Map (potentially immutable) of properties and their dependent schemas
     * @since 4.0
     */
    Map<String, Schema> getDependentSchemas();

    /**
     * Sets the dependentSchemas property of this Schema instance.
     * <p>
     * For each name and property pair in the map, if the object contains a property with the given name, it must match
     * the corresponding schema.
     *
     * @param dependentSchemas
     *            a map of properties and their dependent schemas
     * @since 4.0
     */
    void setDependentSchemas(Map<String, Schema> dependentSchemas);

    /**
     * Sets the dependentSchemas property of this Schema instance.
     * <p>
     * For each name and property pair in the map, if the object contains a property with the given name, it must match
     * the corresponding schema.
     *
     * @param dependentSchemas
     *            a map of properties and their dependent schemas
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema dependentSchemas(Map<String, Schema> dependentSchemas) {
        setDependentSchemas(dependentSchemas);
        return this;
    }

    /**
     * Sets the dependent schema for a property name.
     * <p>
     * If the object contains a property with the given name, it must match the dependent schema.
     *
     * @param propertyName
     *            the property name
     * @param schema
     *            the dependent schema
     * @return the current Schema instance
     * @since 4.0
     */
    Schema addDependentSchema(String propertyName, Schema schema);

    /**
     * Removes the dependent schema for a property name.
     *
     * @param propertyName
     *            the property name
     * @since 4.0
     */
    void removeDependentSchema(String propertyName);

    /**
     * Returns the prefixItems property of this Schema instance.
     * <p>
     * If the object is an array, the nth item in the array must match the nth schema in this list.
     *
     * @return a copy List (potentially immutable) of prefix item schemas
     * @since 4.0
     */
    List<Schema> getPrefixItems();

    /**
     * Sets the prefixItems property of this Schema instance.
     * <p>
     * If the object is an array, the nth item in the array must match the nth schema in this list.
     *
     * @param prefixItems
     *            a list of prefix item schemas
     * @since 4.0
     */
    void setPrefixItems(List<Schema> prefixItems);

    /**
     * Sets the prefixItems property of this Schema instance.
     * <p>
     * If the object is an array, the nth item in the array must match the nth schema in this list.
     *
     * @param prefixItems
     *            a list of prefix item schemas
     * @return current Schema instance
     * @since 4.0
     */
    default Schema prefixItems(List<Schema> prefixItems) {
        setPrefixItems(prefixItems);
        return this;
    }

    /**
     * Adds a schema to the end of the prefixItems list.
     *
     * @param prefixItem
     *            the schema to add to the prefixItems list
     * @return current Schema instance
     * @since 4.0
     */
    Schema addPrefixItem(Schema prefixItem);

    /**
     * Removes a schema from the prefixItems list.
     *
     * @param prefixItem
     *            the schema to remove from the prefixItems list
     * @since 4.0
     */
    void removePrefixItem(Schema prefixItem);

    /**
     * Returns the contains property of this Schema instance.
     * <p>
     * If the object is an array, at least one item in the array must match the returned schema.
     *
     * @return a schema that one item in the array should match
     * @since 4.0
     */
    Schema getContains();

    /**
     * Sets the contains property of this Schema instance.
     * <p>
     * If the object is an array, at least one item in the array must match the returned schema.
     *
     * @param contains
     *            a schema that one item in the array should match
     * @since 4.0
     */
    void setContains(Schema contains);

    /**
     * Sets the contains property of this Schema instance.
     * <p>
     * If the object is an array, at least one item in the array must match the returned schema.
     *
     * @param contains
     *            a schema that one item in the array should match
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema contains(Schema contains) {
        setContains(contains);
        return this;
    }

    /**
     * Returns the patternProperties property from this Schema instance.
     * <p>
     * The value of patternProperties is a map from a regular expression to a schema. For each string and schema pair in
     * the map, if a property name is matched by the regular expression then the value of that property must validate
     * against the schema.
     *
     * @return a copy Map (potentially immutable) of regular expression and schema pairs
     * @since 4.0
     */
    Map<String, Schema> getPatternProperties();

    /**
     * Sets the patternProperties property from this Schema instance.
     * <p>
     * The value of patternProperties is a map from a regular expression to a schema. For each string and schema pair in
     * the map, if a property name is matched by the regular expression then the value of that property must validate
     * against the schema.
     *
     * @param patternProperties
     *            a map of regular expression and schema pairs
     * @since 4.0
     */
    void setPatternProperties(Map<String, Schema> patternProperties);

    /**
     * Sets the patternProperties property from this Schema instance.
     * <p>
     * The value of patternProperties is a map from a regular expression to a schema. For each string and schema pair in
     * the map, if a property name is matched by the regular expression then the value of that property must validate
     * against the schema.
     *
     * @param patternProperties
     *            a map of regular expression and schema pairs
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema patternProperties(Map<String, Schema> patternProperties) {
        setPatternProperties(patternProperties);
        return this;
    }

    /**
     * Adds a regular expression and schema pair to the list of pattern properties.
     * <p>
     * The value of patternProperties is a map from a regular expression to a schema. For each string and schema pair in
     * the map, if a property name is matched by the regular expression then the value of that property must validate
     * against the schema.
     *
     * @param regularExpression
     *            the regular expression to add
     * @param schema
     *            the schema that a property value must validate against if its name matches {@code regularExpression}
     * @return the current Schema instance
     * @since 4.0
     */
    Schema addPatternProperty(String regularExpression, Schema schema);

    /**
     * Removes a regular expression and its corresponding schema pair from the list of pattern properties.
     *
     * @param regularExpression
     *            the regular expression to remove
     * @since 4.0
     */
    void removePatternProperty(String regularExpression);

    /**
     * Returns the propertyNames property from this Schema instance. Each property <em>name</em> in the object must
     * validate against this schema.
     *
     * @return the schema which each property name must validate against
     * @since 4.0
     */
    Schema getPropertyNames();

    /**
     * Sets the propertyNames property from this Schema instance. Each property <em>name</em> in the object must
     * validate against this schema.
     *
     * @param propertyNameSchema
     *            the schema which each property name must validate against
     * @since 4.0
     */
    void setPropertyNames(Schema propertyNameSchema);

    /**
     * Sets the propertyNames property from this Schema instance. Each property <em>name</em> in the object must
     * validate against this schema.
     *
     * @param propertyNameSchema
     *            the schema which each property name must validate against
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema propertyNames(Schema propertyNameSchema) {
        setPropertyNames(propertyNameSchema);
        return this;
    }

    /**
     * Returns the unevaluatedItems property of this Schema instance.
     * <p>
     * Items which have not successfully validated against {@code prefixItems}, {@code items}, or {@code contains} must
     * validate against this schema.
     *
     * @return a schema that unevaluated array items must validate against
     * @since 4.0
     */
    Schema getUnevaluatedItems();

    /**
     * Sets the unevaluatedItems property of this Schema instance.
     * <p>
     * Items which have not successfully validated against {@code prefixItems}, {@code items}, or {@code contains} must
     * validate against this schema.
     *
     * @param unevaluatedItems
     *            a schema that unevaluated array items must validate against
     * @since 4.0
     */
    void setUnevaluatedItems(Schema unevaluatedItems);

    /**
     * Sets the unevaluatedItems property of this Schema instance.
     * <p>
     * Items which have not successfully validated against {@code prefixItems}, {@code items}, or {@code contains} must
     * validate against this schema.
     *
     * @param unevaluatedItems
     *            a schema that unevaluated array items must validate against
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema unevaluatedItems(Schema unevaluatedItems) {
        setUnevaluatedItems(unevaluatedItems);
        return this;
    }

    /**
     * Returns the unevaluatedProperties property of this Schema instance.
     * <p>
     * Property values which have not successfully validated against {@code properties}, {@code patternProperties}, or
     * {@code additionalProperties} must validate against this schema.
     *
     * @return a schema that unevaluated object properties must validate against
     * @since 4.0
     */
    Schema getUnevaluatedProperties();

    /**
     * Sets the unevaluatedProperties property of this Schema instance.
     * <p>
     * Property values which have not successfully validated against {@code properties}, {@code patternProperties}, or
     * {@code additionalProperties} must validate against this schema.
     *
     * @param unevaluatedProperties
     *            a schema that unevaluated object properties must validate against
     * @since 4.0
     */
    void setUnevaluatedProperties(Schema unevaluatedProperties);

    /**
     * Sets the unevaluatedProperties property of this Schema instance.
     * <p>
     * Property values which have not successfully validated against {@code properties}, {@code patternProperties}, or
     * {@code additionalProperties} must validate against this schema.
     *
     * @param unevaluatedProperties
     *            a schema that unevaluated object properties must validate against
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema unevaluatedProperties(Schema unevaluatedProperties) {
        setUnevaluatedProperties(unevaluatedProperties);
        return this;
    }

    /**
     * Returns the const property from this Schema instance. Indicates that the object must have a specific value.
     *
     * @return the value that the object must have
     * @since 4.0
     */
    Object getConstValue();

    /**
     * Sets the const property from this Schema instance. Indicates that the object must have a specific value.
     *
     * @param constValue
     *            the value that the object must have
     * @since 4.0
     */
    void setConstValue(Object constValue);

    /**
     * Sets the const property from this Schema instance. Indicates that the object must have a specific value.
     *
     * @param constValue
     *            the value that the object must have
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema constValue(Object constValue) {
        setConstValue(constValue);
        return this;
    }

    /**
     * Returns the maxContains property from this Schema instance. Specifies that {@code contains} must match no more
     * than this many items in the array.
     *
     * @return the max number of items which may be matched by {@code contains}
     * @since 4.0
     */
    Integer getMaxContains();

    /**
     * Sets the maxContains property from this Schema instance. Specifies that {@code contains} must match no more than
     * this many items in the array.
     *
     * @param maxContains
     *            the max number of items which may be matched by {@code contains}
     * @since 4.0
     */
    void setMaxContains(Integer maxContains);

    /**
     * Sets the maxContains property from this Schema instance. Specifies that {@code contains} must match no more than
     * this many items in the array.
     *
     * @param maxContains
     *            the maximum number of items which may be matched by {@code contains}
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema maxContains(Integer maxContains) {
        setMaxContains(maxContains);
        return this;
    }

    /**
     * Returns the minContains property from this Schema instance. Specifies that {@code contains} must match at least
     * this many items in the array.
     *
     * @return the minimum number of items which may be matched by {@code contains}
     * @since 4.0
     */
    Integer getMinContains();

    /**
     * Sets the minContains property from this Schema instance. Specifies that {@code contains} must match at least this
     * many items in the array.
     *
     * @param minContains
     *            the minimum number of items which may be matched by {@code contains}
     * @since 4.0
     */
    void setMinContains(Integer minContains);

    /**
     * Sets the minContains property from this Schema instance. Specifies that {@code contains} must match at least this
     * many items in the array.
     *
     * @param minContains
     *            the minimum number of items which may be matched by {@code contains}
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema minContains(Integer minContains) {
        setMinContains(minContains);
        return this;
    }

    /**
     * Returns the dependentRequired property of this Schema instance.
     * <p>
     * For each entry in the map, if the key exists as a property name in the object, then the list of names in the
     * value must also exist as property names in the object.
     *
     * @return a copy Map (potentially immutable) of property names to lists of additional required property names
     * @since 4.0
     */
    Map<String, List<String>> getDependentRequired();

    /**
     * Sets the dependentRequired property of this Schema instance.
     * <p>
     * For each entry in the map, if the key exists as a property name in the object, then the list of names in the
     * value must also exist as property names in the object.
     *
     * @param dependentRequired
     *            a map of property names to lists of additional required property names
     * @since 4.0
     */
    void setDependentRequired(Map<String, List<String>> dependentRequired);

    /**
     * Sets the dependentRequired property of this Schema instance.
     * <p>
     * For each entry in the map, if the key exists as a property name in the object, then the list of names in the
     * value must also exist as property names in the object.
     *
     * @param dependentRequired
     *            a map of property names to lists of additional required property names
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema dependentRequired(Map<String, List<String>> dependentRequired) {
        setDependentRequired(dependentRequired);
        return this;
    }

    /**
     * Sets the list of additional property names that are required if a property named {@code propertyName} exists.
     *
     * @param propertyName
     *            the property name
     * @param additionalRequiredPropertyNames
     *            the names of additional properties which are required if {@code propertyName} exists to add
     * @return the current Schema instance
     * @since 4.0
     */
    Schema addDependentRequired(String propertyName, List<String> additionalRequiredPropertyNames);

    /**
     * Removes the list of additional property names that are required if a property named {@code propertyName} exists.
     *
     * @param propertyName
     *            the property name
     * @since 4.0
     */
    void removeDependentRequired(String propertyName);

    /**
     * Returns the contentEncoding property from this Schema instance.
     * <p>
     * Specifies the encoding used to represent binary data as a string (e.g. base64).
     *
     * @return the encoding type
     * @since 4.0
     */
    String getContentEncoding();

    /**
     * Sets the contentEncoding property from this Schema instance.
     * <p>
     * Specifies the encoding used to represent binary data as a string (e.g. base64).
     *
     * @param contentEncoding
     *            the encoding type
     * @since 4.0
     */
    void setContentEncoding(String contentEncoding);

    /**
     * Sets the contentEncoding property from this Schema instance.
     * <p>
     * Specifies the encoding used to represent binary data as a string (e.g. base64).
     *
     * @param contentEncoding
     *            the encoding type
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema contentEncoding(String contentEncoding) {
        setContentEncoding(contentEncoding);
        return this;
    }

    /**
     * Returns the contentMediaType property from this Schema instance.
     * <p>
     * Specifies the media type of the content of a string.
     *
     * @return the media type
     * @since 4.0
     */
    String getContentMediaType();

    /**
     * Sets the contentMediaType property from this Schema instance.
     * <p>
     * Specifies the media type of the content of a string.
     *
     * @param contentMediaType
     *            the media type
     * @since 4.0
     */
    void setContentMediaType(String contentMediaType);

    /**
     * Sets the contentMediaType property from this Schema instance.
     * <p>
     * Specifies the media type of the content of a string.
     *
     * @param contentMediaType
     *            the media type
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema contentMediaType(String contentMediaType) {
        setContentMediaType(contentMediaType);
        return this;
    }

    /**
     * Returns the contentSchema property from this Schema instance.
     * <p>
     * If {@code contentMediaType} is a media type that maps into JSON Schema's data model, this property specifies a
     * schema that the data in the string must conform to.
     *
     * @return the schema for the data within the string
     * @since 4.0
     */
    Schema getContentSchema();

    /**
     * Sets the contentSchema property from this Schema instance.
     * <p>
     * If {@code contentMediaType} is a media type that maps into JSON Schema's data model, this property specifies a
     * schema that the data in the string must conform to.
     *
     * @param contentSchema
     *            the schema for the data within the string
     * @since 4.0
     */
    void setContentSchema(Schema contentSchema);

    /**
     * Sets the contentSchema property from this Schema instance.
     * <p>
     * If {@code contentMediaType} is a media type that maps into JSON Schema's data model, this property specifies a
     * schema that the data in the string must conform to.
     *
     * @param contentSchema
     *            the schema for the data within the string
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema contentSchema(Schema contentSchema) {
        setContentSchema(contentSchema);
        return this;
    }

    /**
     * Returns whether this Schema is a boolean schema.
     * <p>
     * If this property is not {@code null}, then all other properties are ignored and the schema will be represented by
     * a boolean {@code true} or {@code false} value.
     *
     * @return the boolean value of this schema, or {@code null} if it is not a boolean schema
     * @since 4.0
     */
    Boolean getBooleanSchema();

    /**
     * Sets this schema to a boolean value.
     * <p>
     * If this property is not {@code null}, then all other properties are ignored and the schema will be represented by
     * a boolean {@code true} or {@code false} value.
     *
     * @param booleanSchema
     *            the boolean value of this schema, or {@code null} if it is not a boolean schema
     * @since 4.0
     */
    void setBooleanSchema(Boolean booleanSchema);

    /**
     * Sets this schema to a boolean value.
     * <p>
     * If this property is not {@code null}, then all other properties are ignored and the schema will be represented by
     * a boolean {@code true} or {@code false} value.
     *
     * @param booleanSchema
     *            the boolean value of this schema, or {@code null} if it is not a boolean schema
     * @return the current Schema instance
     * @since 4.0
     */
    default Schema booleanSchema(Boolean booleanSchema) {
        setBooleanSchema(booleanSchema);
        return this;
    }

    /**
     * Returns the examples property of this Schema instance.
     *
     * @return a copy List (potentially immutable) of example objects which this schema could describe
     * @since 4.0
     */
    List<Object> getExamples();

    /**
     * Sets the examples property of this Schema instance.
     *
     * @param examples
     *            a list of example objects which this schema could describe
     * @since 4.0
     */
    void setExamples(List<Object> examples);

    /**
     * Sets the examples property of this Schema instance.
     *
     * @param examples
     *            a list of example objects which this schema could describe
     * @return current Schema instance
     * @since 4.0
     */
    default Schema examples(List<Object> examples) {
        setExamples(examples);
        return this;
    }

    /**
     * Adds an example to the examples list.
     *
     * @param example
     *            the example to add to the examples list
     * @return current Schema instance
     * @since 4.0
     */
    Schema addExample(Object example);

    /**
     * Removes an example from the examples list.
     *
     * @param example
     *            the example to remove from the examples list
     * @since 4.0
     */
    void removeExample(Object example);

    /**
     * Gets a schema property by name.
     * <p>
     * Allows access to arbitrary properties in a schema object, allowing use of alternative schema dialects which use
     * different property names (or the same property names with different data types).
     * <p>
     * When using the standard schema dialect, this method can be used to retrieve values set by other methods. E.g.
     *
     * <pre>
     * {@code
     * schema.setMinimum(new BigDecimal(3));
     * BigDecimal minimum = (BigDecimal) schema.get("minimum"); // returns 3
     * }
     * </pre>
     *
     * @param propertyName
     *            the property name
     * @return the value of the named property, or {@code null} if a property with the given name is not set
     */
    Object get(String propertyName);

    /**
     * Sets a schema property.
     * <p>
     * Allows the modifications of arbitrary schema properties in a schema properties, allowing use of alternative
     * schema dialects which use different property names (or the same property names with different data types).
     * <p>
     * Passing {@code null} as the {@code value} removes the property from the schema object.
     * <p>
     * {@code value} must be one of the following types, otherwise non-portable behavior results:
     * <ul>
     * <li>Any primitive type
     * <li>Any primitive wrapper class
     * <li>{@code null}
     * <li>{@code String}
     * <li>{@code BigDecimal}
     * <li>{@code BigInteger}
     * <li>Any type which {@link OASFactory} can create
     * <li>Any Enumeration
     * <li>{@code List} where every value is a permitted type
     * <li>{@code Map} where every key is a {@code String} and every value is a permitted type
     * </ul>
     *
     * <p>
     * When using the standard schema dialect, values set by this method can be retrieved by other methods. E.g.
     *
     * <pre>
     * {@code
     * schema.set("minimum", new BigDecimal(3));
     * BigDecimal minimum = schema.getMinimum(); // returns 3
     * }
     * </pre>
     *
     * @param propertyName
     *            the property name
     * @param value
     *            the value to set, or {@code null} to remove the property
     * @return the current Schema instance
     */
    Schema set(String propertyName, Object value);

    /**
     * Gets all properties of a schema.
     * <p>
     * Equivalent to calling {@link #get(String)} for each property set to a non-{@code null} value and putting them all
     * into a {@code Map}.
     *
     * @return a {@code Map} of property names to their corresponding values
     */
    Map<String, ?> getAll();

    /**
     * Sets all properties of a schema.
     * <p>
     * Equivalent to clearing all properties and then setting each property with {@link #set(String, Object)}.
     *
     * @param allProperties
     *            the properties to set. Each value in the map must be valid according to the rules in
     *            {@link #set(String, Object)}
     */
    void setAll(Map<String, ?> allProperties);
}
