/**
 * Copyright (c) 2017 Contributors to the Eclipse Foundation
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
package org.eclipse.microprofile.openapi.reader;

import static java.util.Collections.emptyMap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASModelReader;
import org.eclipse.microprofile.openapi.models.Components;
import org.eclipse.microprofile.openapi.models.ExternalDocumentation;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.PathItem;
import org.eclipse.microprofile.openapi.models.Paths;
import org.eclipse.microprofile.openapi.models.examples.Example;
import org.eclipse.microprofile.openapi.models.headers.Header;
import org.eclipse.microprofile.openapi.models.info.Contact;
import org.eclipse.microprofile.openapi.models.info.Info;
import org.eclipse.microprofile.openapi.models.info.License;
import org.eclipse.microprofile.openapi.models.links.Link;
import org.eclipse.microprofile.openapi.models.media.Content;
import org.eclipse.microprofile.openapi.models.media.MediaType;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.parameters.Parameter.In;
import org.eclipse.microprofile.openapi.models.parameters.RequestBody;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;
import org.eclipse.microprofile.openapi.models.responses.APIResponses;
import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type;
import org.eclipse.microprofile.openapi.models.servers.Server;
import org.eclipse.microprofile.openapi.models.servers.ServerVariable;
import org.eclipse.microprofile.openapi.models.tags.Tag;

public class MyOASModelReaderImpl implements OASModelReader {

    @Override
    @SuppressWarnings("checkstyle:methodlength")
    public OpenAPI buildModel() {
        return OASFactory.createObject(OpenAPI.class)
                .info(OASFactory.createObject(Info.class)
                        .title("AirlinesRatingApp API")
                        .version("1.0")
                        .termsOfService("http://airlinesratingapp.com/terms")
                        .contact(OASFactory.createObject(Contact.class)
                                .name("AirlinesRatingApp API Support")
                                .url("http://exampleurl.com/contact")
                                .email("techsupport@airlinesratingapp.com"))
                        .license(OASFactory.createObject(License.class)
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
                .security(new ArrayList<SecurityRequirement>())
                .addSecurityRequirement(OASFactory.createObject(SecurityRequirement.class)
                        .addScheme("airlinesRatingApp_auth"))
                .servers(new ArrayList<Server>())
                .addServer(OASFactory.createObject(Server.class)
                        .url("https://{username}.gigantic-server.com:{port}/{basePath}")
                        .description("The production API server")
                        .addVariable("username", OASFactory.createObject(ServerVariable.class)
                                .defaultValue("user1")
                                .description("Reviews of the app by users")
                                .enumeration(new ArrayList<String>())
                                .addEnumeration("user1")
                                .addEnumeration("user2"))
                        .addVariable("port", OASFactory.createObject(ServerVariable.class)
                                .defaultValue("8443")
                                .description("Booking data"))
                        .addVariable("user", OASFactory.createObject(ServerVariable.class)
                                .defaultValue("user")
                                .description("User data"))
                        .addVariable("basePath", OASFactory.createObject(ServerVariable.class)
                                .defaultValue("v2")))
                .addServer(OASFactory.createObject(Server.class)
                        .url("https://test-server.com:80/basePath")
                        .description("The test API server"))
                .components(OASFactory.createObject(Components.class)
                        .schemas(new HashMap<String, Schema>())
                        .addSchema("Bookings", OASFactory.createObject(Schema.class)
                                .addType(Schema.SchemaType.INTEGER)
                                .title("Bookings")
                                .ref("#/components.schemas.Booking"))
                        .addSchema("Airlines", OASFactory.createObject(Schema.class)
                                .addType(Schema.SchemaType.INTEGER)
                                .title("Airlines"))
                        .addSchema("AirlinesRef", OASFactory.createObject(Schema.class)
                                .ref("#/components/schemas/Airlines"))
                        .addSchema("Flight", OASFactory.createSchema()
                                .addType(Schema.SchemaType.OBJECT))
                        .addSchema("id", OASFactory.createObject(Schema.class)
                                .addType(Schema.SchemaType.INTEGER)
                                .format("int32"))
                        .addSchema("custom", OASFactory.createSchema()
                                .schemaDialect("http://example.com/myCustomSchema")
                                .set("shortKey", (short) 1)
                                .set("intKey", 2)
                                .set("longKey", 3L)
                                .set("booleanKey", true)
                                .set("charKey", 'a')
                                .set("stringKey", "string")
                                .set("floatKey", 3.5f)
                                .set("doubleKey", 3.5d)
                                .set("bigDecimalKey", new BigDecimal("3.5"))
                                .set("bigIntegerKey", new BigInteger("7"))
                                .set("extDocKey", OASFactory.createExternalDocumentation().description("test"))
                                .set("operationKey", OASFactory.createOperation().description("test"))
                                .set("pathItemKey", OASFactory.createPathItem().description("test"))
                                .set("pathsKey", OASFactory.createPaths()
                                        .addPathItem("test", OASFactory.createPathItem().description("test")))
                                .set("callbackKey", OASFactory.createCallback()
                                        .addPathItem("test", OASFactory.createPathItem().description("test")))
                                .set("exampleKey", OASFactory.createExample().value("test"))
                                .set("headerKey", OASFactory.createHeader().description("test"))
                                .set("contactKey", OASFactory.createContact().name("test"))
                                .set("infoKey", OASFactory.createInfo().title("test").version("1.0"))
                                .set("licenseKey", OASFactory.createLicense().name("test"))
                                .set("linkKey", OASFactory.createLink().operationId("getTestFlights"))
                                .set("contentKey", OASFactory.createContent()
                                        .addMediaType("test", OASFactory.createMediaType().example("test")))
                                .set("discriminatorKey", OASFactory.createDiscriminator().propertyName("test"))
                                .set("schemaKey", OASFactory.createSchema().title("test"))
                                .set("xmlKey", OASFactory.createXML().name("test"))
                                .set("parameterKey", OASFactory.createParameter().name("test").in(In.PATH))
                                .set("requestBodyKey", OASFactory.createRequestBody()
                                        .content(OASFactory.createContent()
                                                .addMediaType("test", OASFactory.createMediaType().example("test"))))
                                .set("apiResponseKey", OASFactory.createAPIResponse().description("test"))
                                .set("apiResponsesKey", OASFactory.createAPIResponses()
                                        .addAPIResponse("200", OASFactory.createAPIResponse().description("test")))
                                .set("oAuthFlowKey",
                                        OASFactory.createOAuthFlow().authorizationUrl("http://example.com"))
                                .set("oAuthFlowsKey", OASFactory.createOAuthFlows().implicit(
                                        OASFactory.createOAuthFlow().authorizationUrl("http://example.com")
                                                .scopes(emptyMap())))
                                .set("securityReqKey", OASFactory.createSecurityRequirement().addScheme("test"))
                                .set("securitySchemeKey", OASFactory.createSecurityScheme()
                                        .type(Type.HTTP)
                                        .scheme("Basic"))
                                .set("serverKey", OASFactory.createServer().url("http://example.com"))
                                .set("serverVarKey", OASFactory.createServerVariable().defaultValue("test"))
                                .set("tagKey", OASFactory.createTag().name("test"))
                                .set("enumKey", DayOfWeek.MONDAY)
                                .set("listKey", Arrays.asList(
                                        "test",
                                        OASFactory.createXML().name("test")))
                                .set("mapKey", Collections.singletonMap("test", DayOfWeek.THURSDAY)))
                        .responses(new HashMap<String, APIResponse>())
                        .addResponse("FoundAirlines", OASFactory.createObject(APIResponse.class)
                                .description("successfully found airlines")
                                .content(OASFactory.createObject(Content.class)
                                        .addMediaType("application/json", OASFactory.createObject(MediaType.class)
                                                .schema(OASFactory.createObject(Schema.class)
                                                        .addType(Schema.SchemaType.ARRAY)))))
                        .addResponse("FoundBookings", OASFactory.createObject(APIResponse.class)
                                .description("Bookings retrieved")
                                .content(OASFactory.createObject(Content.class)
                                        .addMediaType("application/json", OASFactory.createObject(MediaType.class)
                                                .schema(OASFactory.createObject(Schema.class)
                                                        .addType(Schema.SchemaType.ARRAY)
                                                        .ref("#/components.schemas.Booking")))))
                        .addResponse("FoundBookingsRef", OASFactory.createAPIResponse()
                                .ref("#/components/responses/FoundBookings")
                                .description("Found Bookings Reference"))
                        .parameters(new HashMap<String, Parameter>())
                        .addParameter("departureDate", OASFactory.createObject(Parameter.class)
                                .required(true)
                                .description("Customer departure date")
                                .schema(OASFactory.createObject(Schema.class)))
                        .addParameter("username", OASFactory.createObject(Parameter.class)
                                .required(true)
                                .description("The name that needs to be deleted")
                                .schema(OASFactory.createObject(Schema.class)))
                        .addParameter("usernameRef", OASFactory.createParameter()
                                .ref("#/components/parameters/username")
                                .description("username reference"))
                        .examples(new HashMap<String, Example>())
                        .addExample("review", OASFactory.createObject(Example.class)
                                .summary("External review example")
                                .description("This example exemplifies the content on our site.")
                                .externalValue("http://foo.bar/examples/review-example.json"))
                        .addExample("user", OASFactory.createObject(Example.class)
                                .summary("External user example")
                                .externalValue("http://foo.bar/examples/user-example.json"))
                        .addExample("userRef", OASFactory.createExample()
                                .ref("#/componets/examples/user")
                                .summary("Referenced example")
                                .description("User reference"))
                        .requestBodies(new HashMap<String, RequestBody>())
                        .addRequestBody("review", OASFactory.createObject(RequestBody.class)
                                .required(true)
                                .description("example review to add")
                                .content(OASFactory.createObject(Content.class)
                                        .addMediaType("application/json", OASFactory.createObject(MediaType.class)
                                                .schema(OASFactory.createObject(Schema.class)
                                                        .ref("#/components.schemas.Review")))))
                        .addRequestBody("reviewRef", OASFactory.createRequestBody()
                                .ref("#/components/requestBodies/review")
                                .description("Review reference"))
                        .headers(new HashMap<String, Header>())
                        .addHeader("Max-Rate", OASFactory.createObject(Header.class)
                                .description("Maximum rate")
                                .schema(OASFactory.createObject(Schema.class)
                                        .addType(Schema.SchemaType.INTEGER))
                                .required(true)
                                .allowEmptyValue(true)
                                .deprecated(true))
                        .addHeader("Request-Limit", OASFactory.createObject(Header.class)
                                .description("The number of allowed requests in the current period")
                                .schema(OASFactory.createObject(Schema.class)
                                        .addType(Schema.SchemaType.INTEGER)))
                        .addHeader("Request-Limit-Ref", OASFactory.createHeader()
                                .ref("#/components/headers/Request-Limit")
                                .description("Request-Limit reference"))
                        .securitySchemes(new HashMap<String, SecurityScheme>())
                        .addSecurityScheme("httpTestScheme", OASFactory.createObject(SecurityScheme.class)
                                .description("user security scheme")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("testScheme"))
                        .addSecurityScheme("httpTestSchemeRef", OASFactory.createSecurityScheme()
                                .ref("#/components/securitySchemes/httpTestScheme")
                                .description("httpTestScheme reference"))
                        .links(new HashMap<String, Link>())
                        .addLink("UserName", OASFactory.createObject(Link.class)
                                .description("The username corresponding to provided user id")
                                .operationId("getUserByName")
                                .parameters(new HashMap<String, Object>())
                                .addParameter("userId", "$request.link-path.userId"))
                        .addLink("UserNameRef", OASFactory.createLink()
                                .ref("#/components/links/UserName")
                                .description("UserName reference"))
                        .callbacks(new HashMap<>())
                        .addCallback("availabilityCallback", OASFactory.createCallback()
                                .addPathItem("http://localhost:9080/oas3-airlines/availability", OASFactory
                                        .createPathItem()
                                        .GET(OASFactory.createOperation()
                                                .summary("Retrieve available flights")
                                                .responses(OASFactory.createAPIResponses()
                                                        .addAPIResponse("200", OASFactory.createAPIResponse()
                                                                .description("successful operation")
                                                                .content(OASFactory.createContent()
                                                                        .addMediaType("application/json", OASFactory
                                                                                .createMediaType()
                                                                                .schema(OASFactory.createSchema()
                                                                                        .ref("#/components/schemas/Flight")))))))))
                        .addCallback("availabilityCallbackRef", OASFactory.createCallback()
                                .ref("#/components/callbacks/availabilityCallback"))
                        .pathItems(new HashMap<>())
                        .addPathItem("idCrud", OASFactory.createPathItem()
                                .DELETE(OASFactory.createOperation()
                                        .responses(OASFactory.createAPIResponses()
                                                .addAPIResponse("202", OASFactory.createAPIResponse()
                                                        .content(OASFactory.createContent())
                                                        .description("Delete item"))))
                                .addParameter(OASFactory.createParameter()
                                        .name("id")
                                        .in(In.PATH)
                                        .description("The item parameter")
                                        .required(true))))
                .tags(new ArrayList<Tag>())
                .addTag(OASFactory.createObject(Tag.class)
                        .name("Get Airlines")
                        .description("method to get all airlines"))
                .addTag(OASFactory.createObject(Tag.class)
                        .name("Retrieve Airlines")
                        .description("method to retrieve all airlines"))
                .addTag(OASFactory.createObject(Tag.class)
                        .name("user")
                        .description("Operations about user"))
                .addTag(OASFactory.createObject(Tag.class)
                        .name("create")
                        .description("Operations about create"))
                .addTag(OASFactory.createObject(Tag.class)
                        .name("Bookings")
                        .description("All the bookings methods"))
                .addTag(OASFactory.createObject(Tag.class)
                        .name("Airlines")
                        .description("All the airlines methods"))
                .addTag(OASFactory.createObject(Tag.class)
                        .name("Availability")
                        .description("All the availability methods"))
                .addTag(OASFactory.createObject(Tag.class)
                        .name("Get Flights")
                        .description("method to retrieve all flights available")
                        .externalDocs(OASFactory.createObject(ExternalDocumentation.class)
                                .description("A list of all the flights offered by the app")
                                .url("http://airlinesratingapp.com/ourflights")))
                .externalDocs(OASFactory.createObject(ExternalDocumentation.class)
                        .description("instructions for how to deploy this app")
                        .url("https://github.com/microservices-api/oas3-airlines/blob/master/README.md"))
                .addWebhook("bookingEvent", OASFactory.createPathItem()
                        .PUT(OASFactory.createOperation()
                                .summary("Notifies that a booking has been created")
                                .requestBody(OASFactory.createRequestBody()
                                        .content(OASFactory.createContent()
                                                .addMediaType("application/json", OASFactory.createMediaType()
                                                        .schema(OASFactory.createSchema()
                                                                .ref("#/components/schemas/Booking")))))
                                .responses(OASFactory.createAPIResponses()
                                        .addAPIResponse("204", OASFactory.createAPIResponse()
                                                .description(
                                                        "Indicates that the creation event was processed successfully"))))
                        .DELETE(OASFactory.createOperation()
                                .summary("Notifies that a booking has been deleted")
                                .requestBody(OASFactory.createRequestBody()
                                        .content(OASFactory.createContent()
                                                .addMediaType("application/json", OASFactory.createMediaType()
                                                        .schema(OASFactory.createSchema()
                                                                .ref("#/components/schemas/Booking")))))
                                .responses(OASFactory.createAPIResponses()
                                        .addAPIResponse("204", OASFactory.createAPIResponse()
                                                .description(
                                                        "Indicates that the deletion event was processed successfully")))))
                .paths(OASFactory.createObject(Paths.class)
                        .addPathItem("/zepplins/{id}", OASFactory.createObject(PathItem.class)
                                .HEAD(OASFactory.createObject(Operation.class)
                                        .requestBody(OASFactory.createRequestBody()
                                                .ref("#/paths/~1zepplins~1{id}/delete/requestBody")))
                                .GET(OASFactory.createObject(Operation.class)
                                        .requestBody(OASFactory.createRequestBody()
                                                .ref("#/paths/~1zepplins~1{id}/delete/requestBody")))
                                .DELETE(OASFactory.createObject(Operation.class)
                                        .requestBody(OASFactory.createRequestBody()
                                                .description("Something about a zepplin.")
                                                .content(OASFactory.createObject(Content.class)
                                                        .addMediaType("mediaType", OASFactory
                                                                .createObject(MediaType.class))))))
                        .addPathItem("/modelReader/airlines", OASFactory.createObject(PathItem.class)
                                .GET(OASFactory.createObject(Operation.class)
                                        .summary("Retrieve all available airlines")
                                        .operationId("getAirlines")
                                        .responses(OASFactory.createObject(APIResponses.class)
                                                .addAPIResponse("404", OASFactory.createObject(APIResponse.class)
                                                        .description("No airlines found")
                                                        .content(OASFactory.createObject(Content.class)
                                                                .addMediaType("n/a",
                                                                        OASFactory.createObject(MediaType.class)))))))
                        .addPathItem("/availabilityModel", OASFactory.createObject(PathItem.class)
                                .GET(OASFactory.createObject(Operation.class)
                                        .tags(new ArrayList<String>())
                                        .addTag("Availability")
                                        .summary("TEST SUMMARY")
                                        .operationId("getTestFlights")
                                        .responses(OASFactory.createObject(APIResponses.class)
                                                .addAPIResponse("200", OASFactory.createObject(APIResponse.class)
                                                        .description("successful operation")
                                                        .content(OASFactory.createObject(Content.class)
                                                                .addMediaType("application/json", OASFactory
                                                                        .createObject(MediaType.class)
                                                                        .schema(OASFactory.createObject(Schema.class)
                                                                                .addType(Schema.SchemaType.ARRAY)
                                                                                .ref("#/components.schemas.Flight")))))
                                                .addAPIResponse("404", OASFactory.createObject(APIResponse.class)
                                                        .description("No available flights found")
                                                        .content(OASFactory.createObject(Content.class)
                                                                .addMediaType("n/a",
                                                                        OASFactory.createObject(MediaType.class)))))
                                        .parameters(new ArrayList<Parameter>())
                                        .addParameter(OASFactory.createObject(Parameter.class)
                                                .ref("#/components/parameters/departureDate"))
                                        .addParameter(OASFactory.createObject(Parameter.class)
                                                .name("airportFrom")
                                                .required(true)
                                                .in(Parameter.In.QUERY)
                                                .allowEmptyValue(true)
                                                .description("Airport the customer departs from")
                                                .schema(OASFactory.createObject(Schema.class)
                                                        .addType(Schema.SchemaType.STRING)))
                                        .addParameter(OASFactory.createObject(Parameter.class)
                                                .name("returningDate")
                                                .required(true)
                                                .in(Parameter.In.QUERY)
                                                .allowReserved(true)
                                                .description("Customer return date")
                                                .schema(OASFactory.createObject(Schema.class)
                                                        .addType(Schema.SchemaType.STRING)))
                                        .addParameter(OASFactory.createObject(Parameter.class)
                                                .name("airportTo")
                                                .required(true)
                                                .in(Parameter.In.QUERY)
                                                .description("Airport the customer returns to")
                                                .schema(OASFactory.createObject(Schema.class)
                                                        .addType(Schema.SchemaType.STRING)))
                                        .addParameter(OASFactory.createObject(Parameter.class)
                                                .name("numberOfAdults")
                                                .required(true)
                                                .in(Parameter.In.QUERY)
                                                .description("Number of adults on the flight")
                                                .schema(OASFactory.createObject(Schema.class)
                                                        .minimum(new BigDecimal(0))
                                                        .addType(Schema.SchemaType.STRING)))
                                        .addParameter(OASFactory.createObject(Parameter.class)
                                                .name("numberOfChildren")
                                                .required(true)
                                                .deprecated(true)
                                                .in(Parameter.In.QUERY)
                                                .description("Number of children on the flight")
                                                .schema(OASFactory.createObject(Schema.class)
                                                        .minimum(new BigDecimal(0))
                                                        .addType(Schema.SchemaType.STRING)))))
                        .addPathItem("/modelReader/bookings", OASFactory.createObject(PathItem.class)
                                .GET(OASFactory.createObject(Operation.class)
                                        .tags(new ArrayList<String>())
                                        .addTag("bookings")
                                        .summary("Retrieve all bookings for current user")
                                        .operationId("getAllBookings")
                                        .responses(OASFactory.createObject(APIResponses.class)
                                                .addAPIResponse("200", OASFactory.createObject(APIResponse.class)
                                                        .description("Bookings retrieved")
                                                        .content(OASFactory.createObject(Content.class)
                                                                .addMediaType("applictaion/json", OASFactory
                                                                        .createObject(MediaType.class)
                                                                        .schema(OASFactory.createObject(Schema.class)
                                                                                .addType(Schema.SchemaType.ARRAY)
                                                                                .ref("#/components.schemas.Booking")))))
                                                .addAPIResponse("404", OASFactory.createObject(APIResponse.class)
                                                        .description("No bookings found for the user"))))
                                .POST(OASFactory.createObject(Operation.class)
                                        .security(new ArrayList<SecurityRequirement>())
                                        .addSecurityRequirement(OASFactory.createObject(SecurityRequirement.class)
                                                .addScheme("bookingSecurityScheme",
                                                        new ArrayList<String>(
                                                                Arrays.asList("write:bookings", "read:bookings"))))
                                        .summary("Create a booking")
                                        .description(
                                                "Create a new booking record with the booking information provided.")
                                        .operationId("createBooking")
                                        .responses(OASFactory.createObject(APIResponses.class)
                                                .addAPIResponse("201", OASFactory.createObject(APIResponse.class)
                                                        .description("Bookings created")
                                                        .content(OASFactory.createObject(Content.class)
                                                                .addMediaType("text/plain", OASFactory
                                                                        .createObject(MediaType.class)
                                                                        .schema(OASFactory.createObject(Schema.class)
                                                                                .title("id")
                                                                                .description("id of the new booking")
                                                                                .addType(
                                                                                        Schema.SchemaType.STRING)))))))));
    }
}
