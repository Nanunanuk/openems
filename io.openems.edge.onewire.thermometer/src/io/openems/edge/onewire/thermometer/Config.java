package io.openems.edge.onewire.thermometer;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition( //
		name = "OneWire Thermometer", //
		description = "Implements the OneWire Thermometer.")
@interface Config {

	@AttributeDefinition(name = "Component-ID", description = "Unique ID of this Component")
	String id() default "temp0";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;

	@AttributeDefinition(name = "OneWire-ID", description = "ID of OneWire bridge.")
	String bridge_id() default "onewire0";

	@AttributeDefinition(name = "OneWire target filter", description = "This is auto-generated by 'OneWire-ID'.")
	String bridge_target() default "";

	@AttributeDefinition(name = "Address", description = "Address of the OneWire thermometer.")
	String address();

	String webconsole_configurationFactory_nameHint() default "OneWire Thermometer [{id}]";
}