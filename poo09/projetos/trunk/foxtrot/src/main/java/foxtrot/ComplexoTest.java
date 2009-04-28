package foxtrot;

import junit.framework.TestCase;

public class ComplexoTest extends TestCase
{

	public void testDecimal() {
		Complexo c;
		try {
			c= new Complexo(0, new Decimal (5));
			foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
			c.entraUm(calculad2);

			assertEquals("5+1I", c.comandoSoma(calculad2));

		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace ();
		}
	}

	public void testBinario() {
		Complexo c;
		try {
			c= new Complexo(0, new Binario (5));
			foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
			c.entraUm(calculad2);

			assertEquals("0b101+0b1I", c.comandoSoma(calculad2));

		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace ();
		}
	}

	public void testHexadecimal() {
		Complexo c;
		try {
			c= new Complexo(0, new Hexadecimal (5));
			foxtrot.Calculadora calculad2 = new foxtrot.Calculadora();
			c.entraUm(calculad2);

			assertEquals("0x5+0x1I", c.comandoSoma(calculad2));

		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace ();
		}
	}
}
