/**
 */
package be.cetic.simqri.metamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Output Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see be.cetic.simqri.metamodel.MetamodelPackage#getOutputType()
 * @model
 * @generated
 */
public enum OutputType implements Enumerator {
	/**
	 * The '<em><b>SUCCESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUCCESS_VALUE
	 * @generated
	 * @ordered
	 */
	SUCCESS(0, "SUCCESS", "SUCCESS"),

	/**
	 * The '<em><b>FAILURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAILURE_VALUE
	 * @generated
	 * @ordered
	 */
	FAILURE(1, "FAILURE", "FAILURE"),

	/**
	 * The '<em><b>LOWER QUALITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_QUALITY_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_QUALITY(2, "LOWER_QUALITY", "LOWER_QUALITY"),

	/**
	 * The '<em><b>TRASH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRASH_VALUE
	 * @generated
	 * @ordered
	 */
	TRASH(3, "TRASH", "TRASH");

	/**
	 * The '<em><b>SUCCESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUCCESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUCCESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUCCESS_VALUE = 0;

	/**
	 * The '<em><b>FAILURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAILURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAILURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAILURE_VALUE = 1;

	/**
	 * The '<em><b>LOWER QUALITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWER QUALITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_QUALITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_QUALITY_VALUE = 2;

	/**
	 * The '<em><b>TRASH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRASH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRASH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRASH_VALUE = 3;

	/**
	 * An array of all the '<em><b>Output Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OutputType[] VALUES_ARRAY =
		new OutputType[] {
			SUCCESS,
			FAILURE,
			LOWER_QUALITY,
			TRASH,
		};

	/**
	 * A public read-only list of all the '<em><b>Output Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OutputType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Output Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OutputType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OutputType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Output Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OutputType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OutputType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Output Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OutputType get(int value) {
		switch (value) {
			case SUCCESS_VALUE: return SUCCESS;
			case FAILURE_VALUE: return FAILURE;
			case LOWER_QUALITY_VALUE: return LOWER_QUALITY;
			case TRASH_VALUE: return TRASH;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private OutputType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //OutputType
