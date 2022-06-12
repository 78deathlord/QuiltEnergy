package team.voided.quiltenergy.energy;

import team.voided.quiltenergy.HSV;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

public class EnergyUnit {
	private final double value;
	private final ResourceLocation id;
	private final Component name;

	private final HSV energyBarColor;

	public EnergyUnit(double value, ResourceLocation id, Component name, HSV energyBarColor) {
		this.value = value;
		this.id = id;
		this.name = name;
		this.energyBarColor = energyBarColor;
	}

	public double convertTo(EnergyUnit other, double amount) {
		return amount * (this.value / other.value());
	}

	public double convertFrom(EnergyUnit other, double amount) {
		return other.convertTo(this, amount);
	}

	public double value() {
		return value;
	}

	public ResourceLocation id() {
		return id;
	}

	public Component getName() {
		return name;
	}

	public HSV getEnergyBarColor() {
		return energyBarColor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnergyUnit that = (EnergyUnit) o;
		return Double.compare(that.value, value) == 0 && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, id);
	}
}