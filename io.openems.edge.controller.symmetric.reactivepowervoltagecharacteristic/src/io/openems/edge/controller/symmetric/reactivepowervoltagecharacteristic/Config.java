package io.openems.edge.controller.symmetric.reactivepowervoltagecharacteristic;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition( //
		name = "Controller Voltage Reactive Power Characteristic", //
		description = "Defines a power voltage characteristic for storage system.")
@interface Config {

	@AttributeDefinition(name = "Component-ID", description = "Unique ID of this Component")
	String id() default "ctrlReactiveCharacteristic0";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;

	@AttributeDefinition(name = "Ess-ID", description = "ID of Ess device.")
	String ess_id();

	@AttributeDefinition(name = "Meter-ID", description = "ID of Meter.")
	String meter_id();

	@AttributeDefinition(name = "Q by U characteristic ", description = "The graph values for power and percentage")
	String powerVoltConfig() default "[{ \"voltageRatio\" : 0.9,\"power\" : 60 }, { \"voltageRatio\":0.93,\"power\": 0},{\"voltageRatio\":1.07 ,\"power\": 0 },{\"voltageRatio\": 1.1 ,\"power\": -60 }]";

	@AttributeDefinition(name = "Nominal Voltage [V]", description = "The nominal voltage of the grid")
	float nominalVoltage() default 240f;

	@AttributeDefinition(name = "Hysteresis[second]", description = "Wait For Hysteresis to Change the Set Power")
	int waitForHysteresis() default 20;

	@AttributeDefinition(name = "Ess target filter", description = "This is auto-generated by 'Ess-ID'.")
	String ess_target() default "";

	@AttributeDefinition(name = "Meter target filter", description = "This is auto-generated by 'Meter-ID'.")
	String meter_target() default "";

	String webconsole_configurationFactory_nameHint() default "Controller Voltage Reactive Power Characteristic  [{id}]";

}