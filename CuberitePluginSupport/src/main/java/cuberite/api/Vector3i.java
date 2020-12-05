package cuberite.api;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import cuberite.utility.cVector;
import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.Position;
import net.minestom.server.utils.Vector;

public class Vector3i implements cVector {

	private LuaTable luaValue;

	@Override
	public LuaValue getLuaValue() {
		return luaValue;
	}

	public Vector3i() {
		LuaTable vector = LuaValue.tableOf();
		vector.set("x", LuaValue.valueOf(0));
		vector.set("y", LuaValue.valueOf(0));
		vector.set("z", LuaValue.valueOf(0));
		registerFunctions(vector);
	}

	public Vector3i(double X, double Y, double Z) {
		LuaTable vector = LuaValue.tableOf();
		vector.set("x", X);
		vector.set("y", Y);
		vector.set("z", Z);
		registerFunctions(vector);
		luaValue = vector;
	}

	public Vector3i(LuaValue X, LuaValue Y, LuaValue Z) {
		LuaTable vector = LuaValue.tableOf();
		vector.set("x", X);
		vector.set("y", Y);
		vector.set("z", Z);
		registerFunctions(vector);
		luaValue = vector;
	}

	public Vector3i(Position position) {
		LuaTable vector = LuaValue.tableOf();
		vector.set("x", position.getX());
		vector.set("y", position.getY());
		vector.set("z", position.getZ());
		registerFunctions(vector);
		luaValue = vector;
	}

	public Vector3i(Vector someVector) {
		LuaTable vector = LuaValue.tableOf();
		vector.set("x", someVector.getX());
		vector.set("y", someVector.getY());
		vector.set("z", someVector.getZ());
		registerFunctions(vector);
		luaValue = vector;
	}

	public Vector3i(LuaValue luaVector) {
		registerFunctions(luaVector);
		luaValue = (LuaTable) luaVector;
	}

	public Vector3i(BlockPosition position) {
		LuaTable vector = LuaValue.tableOf();
		vector.set("x", position.getX());
		vector.set("y", position.getY());
		vector.set("z", position.getZ());
		registerFunctions(vector);
		luaValue = vector;
	}

	public static class Vector3iConstructor extends ThreeArgFunction {
		@Override
		public LuaValue call(LuaValue X, LuaValue Y, LuaValue Z) {
			if (X.isnumber()) {
				X.checknumber();
				Y.checknumber();
				Z.checknumber();
				return new Vector3i(X, Y, Z).getLuaValue();
			} else {
				return new Vector3i().getLuaValue();
			}
		}
	}

	static class multiply extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			if (value.isnumber()) {
				return new Vector3i(vector.get("x").mul(value), vector.get("y").mul(value), vector.get("z").mul(value))
						.getLuaValue();
			} else {
				double X = vector.get("x").todouble();
				double Y = vector.get("y").todouble();
				double Z = vector.get("z").todouble();

				vector.set("x", Math.floor(X * value.get("x").todouble()));
				vector.set("y", Math.floor(Y * value.get("y").todouble()));
				vector.set("z", Math.floor(Z * value.get("z").todouble()));
				return LuaValue.NIL;
			}
		}
	}

	static class add extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			if (value.isnumber()) {
				return new Vector3i(vector.get("x").add(value.toint()), vector.get("y").add(value.toint()),
						vector.get("z").add(value.toint())).getLuaValue();
			} else {
				return new Vector3i(vector.get("x").add(value.get("x").toint()),
						vector.get("y").add(value.get("y").toint()), vector.get("z").add(value.get("z").toint()))
								.getLuaValue();
			}
		}
	}

	static class subtract extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			if (value.isnumber()) {
				return new Vector3i(vector.get("x").sub(value.toint()), vector.get("y").sub(value.toint()),
						vector.get("z").sub(value.toint())).getLuaValue();
			} else {
				return new Vector3i(vector.get("x").sub(value.get("x").toint()),
						vector.get("y").sub(value.get("y").toint()), vector.get("z").sub(value.get("z").toint()))
								.getLuaValue();
			}
		}
	}

	static class divide extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			if (value.isnumber()) {
				return new Vector3i(vector.get("x").div(value.toint()), vector.get("y").div(value.toint()),
						vector.get("z").div(value.toint())).getLuaValue();
			} else {
				return new Vector3i(vector.get("x").div(value.get("x").toint()),
						vector.get("y").div(value.get("y").toint()), vector.get("z").div(value.get("z").toint()))
								.getLuaValue();
			}
		}
	}

	static class Abs extends OneArgFunction {
		/**
		 * Updates each coord to its absolute value.
		 */
		@Override
		public LuaValue call(LuaValue vector) {
			vector.set("x", Math.abs(vector.get("x").toint()));
			vector.set("y", Math.abs(vector.get("y").toint()));
			vector.set("z", Math.abs(vector.get("z").toint()));
			return vector;
		}
	}

	static class Ceil extends TwoArgFunction {
		/**
		 * Vector3i Returns a new Vector3i object with coords set to math.ceil of this
		 * vector's coords.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.set("x", Math.ceil(vector.get("x").toint()));
			vector.set("y", Math.ceil(vector.get("y").toint()));
			vector.set("z", Math.ceil(vector.get("z").toint()));
			return vector;
		}
	}

	static class Clamp extends ThreeArgFunction {
		/**
		 * minnumber maxnumber Clamps each coord into the specified range.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue min, LuaValue max) {
			int mn = min.toint();
			int mx = min.toint();
			int x = vector.get("x").toint();
			int y = vector.get("y").toint();
			int z = vector.get("z").toint();
			if (x < mn) {
				vector.set("x", min);
			} else if (x > mx) {
				vector.set("x", max);
			}
			;
			if (y < mn) {
				vector.set("y", min);
			} else if (y > mx) {
				vector.set("y", max);
			}
			;
			if (z < mn) {
				vector.set("z", min);
			} else if (z > mx) {
				vector.set("z", max);
			}
			;
			return vector;
		}
	}

	static class Cross extends TwoArgFunction {
		/**
		 * OtherVector3i Vector3i Returns a new Vector3i that is a cross product of this
		 * vector and the specified vector. (a, b, c) x (d, e, f) = (bf - ce, cd - af,
		 * ae - bd)
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			int a = vector.get("x").toint();
			int b = vector.get("y").toint();
			int c = vector.get("z").toint();
			int d = value.get("x").toint();
			int e = value.get("y").toint();
			int f = value.get("z").toint();
			return new Vector3i(b * f - c * e, c * d - a * f, a * e - b * d).getLuaValue();
		}
	}

	static class Dot extends TwoArgFunction {
		/**
		 * OtherVector3i number Returns the dot product of this vector and the specified
		 * vector. (a, b, c) x (d, e, f) = (ad + be + cf)
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			int a = vector.get("x").toint();
			int b = vector.get("y").toint();
			int c = vector.get("z").toint();
			int d = value.get("x").toint();
			int e = value.get("y").toint();
			int f = value.get("z").toint();
			return LuaValue.valueOf(a * d + b * e + c * f);
		}
	}

	static class Equals extends TwoArgFunction {
		/**
		 * AnotherVector Vector3i boolean Returns true if this vector is exactly equal
		 * to the specified vector. Note that this is subject to (possibly imprecise)
		 * floating point math.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			int a = vector.get("x").toint();
			int b = vector.get("y").toint();
			int c = vector.get("z").toint();
			int d = value.get("x").toint();
			int e = value.get("y").toint();
			int f = value.get("z").toint();
			return LuaValue.valueOf(a == d && b == e && c == f);
		}
	}

	static class EqualsEps extends ThreeArgFunction {
		/**
		 * AnotherVector Vector3i Epsnumber boolean Returns true if the differences
		 * between each corresponding coords of this vector and the one specified are
		 * less than the specified Eps.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value, LuaValue eps) {
			int a = vector.get("x").toint();
			int b = vector.get("y").toint();
			int c = vector.get("z").toint();
			int d = value.get("x").toint();
			int e = value.get("y").toint();
			int f = value.get("z").toint();
			int dif = eps.toint();
			return LuaValue.valueOf(Math.abs(a - d) < dif && Math.abs(b - e) < dif && Math.abs(c - f) < dif);
		}
	}

	static class Floor extends TwoArgFunction {
		/**
		 * Vector3i Returns a new Vector3i object with coords set to math.floor of this
		 * vector's coords.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.set("x", Math.floor(vector.get("x").toint()));
			vector.set("y", Math.floor(vector.get("y").toint()));
			vector.set("z", Math.floor(vector.get("z").toint()));
			return vector;
		}
	}

	static class HasNonZeroLength extends OneArgFunction {
		/**
		 * boolean Returns true if the vector has at least one coord non-zero. Note that
		 * this is subject to (possibly imprecise) floating point math.
		 */
		@Override
		public LuaValue call(LuaValue vector) {
			int a = vector.get("x").toint();
			int b = vector.get("y").toint();
			int c = vector.get("z").toint();
			return LuaValue.valueOf(a != 0 || b != 0 || c != 0);
		}
	}

	static class Length extends OneArgFunction {
		/**
		 * number Returns the (euclidean) length of the vector.
		 */
		@Override
		public LuaValue call(LuaValue vector) {
			int a = vector.get("x").toint();
			int b = vector.get("y").toint();
			int c = vector.get("z").toint();
			return LuaValue.valueOf(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
		}
	}

	static class LineCoeffToXYPlane extends TwoArgFunction {
		/**
		 * Vector3i Vector3i Znumber number Returns the coefficient for the line from
		 * the specified vector through this vector to reach the specified Z coord. The
		 * result satisfies the following equation: (this + Result * (Param - this)).z =
		 * Z. Returns the NO_INTERSECTION constant if there's no intersection.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class LineCoeffToXZPlane extends TwoArgFunction {
		/**
		 * Vector3i Vector3i Ynumber number Returns the coefficient for the line from
		 * the specified vector through this vector to reach the specified Y coord. The
		 * result satisfies the following equation: (this + Result * (Param - this)).y =
		 * Y. Returns the NO_INTERSECTION constant if there's no intersection.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class LineCoeffToYZPlane extends TwoArgFunction {
		/**
		 * Vector3i Vector3i Xnumber number Returns the coefficient for the line from
		 * the specified vector through this vector to reach the specified X coord. The
		 * result satisfies the following equation: (this + Result * (Param - this)).x =
		 * X. Returns the NO_INTERSECTION constant if there's no intersection.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class Move extends VarArgFunction {
		/**
		 * Xnumber Ynumber Znumber Adds the specified offsets to each coord, effectively
		 * moving the vector by the specified coord offsets.
		 */
		public LuaValue call(LuaValue[] array, Varargs varargs) {
			LuaValue vector = array[0];
			vector.get("x").add(array[1]);
			vector.get("y").add(array[2]);
			vector.get("z").add(array[3]);
			return vector;
		}
	}

	static class Normalize extends TwoArgFunction {
		/**
		 * Changes this vector so that it keeps current direction as this but is exactly
		 * 1 unit long.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class NormalizeCopy extends TwoArgFunction {
		/**
		 * Vector3i Returns a new vector that has the same direction as this but is
		 * exactly 1 unit long.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class Set extends VarArgFunction {
		/**
		 * Xnumber Ynumber Znumber Sets all the coords in this object.
		 */
		public LuaValue call(LuaValue[] array, Varargs varargs) {
			LuaValue vector = array[0];
			vector.set("x", array[1]);
			vector.set("y", array[2]);
			vector.set("z", array[3]);
			return vector;
		}
	}

	static class SqrLength extends OneArgFunction {
		/**
		 * number Returns the (euclidean) length of this vector, squared. This operation
		 * is slightly less computationally expensive than Length(), while it conserves
		 * some properties of Length(), such as comparison.
		 */
		@Override
		public LuaValue call(LuaValue vector) {
			int a = vector.get("x").toint();
			int b = vector.get("y").toint();
			int c = vector.get("z").toint();
			return LuaValue.valueOf(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
		}
	}

	static class TurnCW extends TwoArgFunction {
		/**
		 * Rotates the vector 90 degrees clockwise around the vertical axis. Note that
		 * this is specific to minecraft's axis ordering, which is X+ left, Z+ down.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class TurnCCW extends TwoArgFunction {
		/**
		 * Rotates the vector 90 degrees counterclockwise around the vertical axis. Note
		 * that this is specific to minecraft's axis ordering, which is X+ left, Z+
		 * down.
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class addedX extends TwoArgFunction {
		/**
		 * ofsnumber Vector3i Returns a copy of the vector, moved by the specified
		 * offset on the X axis
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.get("x").add(value);
			return vector;
		}
	}

	static class addedXZ extends ThreeArgFunction {
		/**
		 * ofsXnumber ofsZnumber Vector3i Returns a copy of the vector, moved by the
		 * specified offsets on the X and Z axes
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue offsetX, LuaValue offsetZ) {
			vector.get("x").add(offsetX);
			vector.get("y").add(offsetZ);
			return vector;
		}
	}

	static class addedY extends TwoArgFunction {
		/**
		 * ofsnumber Vector3i Returns a copy of the vector, moved by the specified
		 * offset on the Y axis
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.get("y").add(value);
			return vector;
		}
	}

	static class addedZ extends TwoArgFunction {
		/**
		 * ofsnumber Vector3i Returns a copy of the vector, moved by the specified
		 * offset on the Z axis
		 */
		@Override
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.get("z").add(value);
			return vector;
		}
	}

	static class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue vector) {
			String output = "cVector3i(" + vector.get("x") + ", " + vector.get("y") + ", " + vector.get("z") + ")";
			return LuaValue.valueOf(output);
		}
	}

	static class Concat extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue valueA, LuaValue valueB) {
			String stringA = valueA.tojstring();
			String stringB = valueB.tojstring();
			LuaValue functionA = valueA.getmetatable().get("__tostring");
			LuaValue functionB = valueB.getmetatable().get("__tostring");

			if (functionA.isfunction()) {
				stringA = functionA.call(valueA).tojstring();
			}

			if (functionB.isfunction()) {
				stringB = functionB.call(valueB).tojstring();
			}

			return LuaValue.valueOf(stringA.concat(stringB));
		}
	}

	@Override
	public void registerFunctions(LuaValue vector) {
		// Setup lua metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__mul", new multiply());
		metatable.set("__add", new add());
		metatable.set("__sub", new subtract());
		metatable.set("__div", new divide());
		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		vector.setmetatable(metatable);

		vector.set("Abs", new Abs());
		vector.set("Ceil", new Ceil());
		vector.set("Clamp", new Clamp());
		vector.set("Cross", new Cross());
		vector.set("Dot", new Dot());
		vector.set("Equals", new Equals());
		vector.set("EqualsEps", new EqualsEps());
		vector.set("Floor", new Floor());
		vector.set("HasNonZeroLength", new HasNonZeroLength());
		vector.set("Length", new Length());
		vector.set("LineCoeffToXYPlane", new LineCoeffToXYPlane());
		vector.set("LineCoeffToXZPlane", new LineCoeffToXZPlane());
		vector.set("LineCoeffToYZPlane", new LineCoeffToYZPlane());
		vector.set("Move", new Move());
		vector.set("Normalize", new Normalize());
		vector.set("NormalizeCopy", new NormalizeCopy());
		vector.set("Set", new Set());
		vector.set("SqrLength", new SqrLength());
		vector.set("TurnCW", new TurnCW());
		vector.set("TurnCCW", new TurnCCW());
		vector.set("addedX", new addedX());
		vector.set("addedXZ", new addedXZ());
		vector.set("addedY", new addedY());
		vector.set("addedZ", new addedZ());

	}

}
