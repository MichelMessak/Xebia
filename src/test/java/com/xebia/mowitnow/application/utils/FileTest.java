package com.xebia.mowitnow.application.utils;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xebia.mowitnow.application.SetupTest;
import com.xebia.mowitnow.application.exception.IncorectFormatCoordinatesOrientationException;
import com.xebia.mowitnow.application.exception.IncorectFormatInstructionException;
import com.xebia.mowitnow.application.exception.IncorectFormatMaximalCoordinatesException;
import com.xebia.mowitnow.application.exception.IncorrectFileException;
import com.xebia.mowitnow.application.model.Coordinates;
import com.xebia.mowitnow.application.model.Mower;
import com.xebia.mowitnow.application.model.Orientation;

public class FileTest extends SetupTest {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Test getMowerList method.
	 * 
	 * @throws IncorectFormatCoordinatesOrientationException
	 * @throws IncorectFormatInstructionException
	 * @throws IncorrectFileException
	 * @throws IncorectFormatMaximalCoordinatesException
	 */
	@Test
	public void getMowerListTest () throws IncorectFormatCoordinatesOrientationException, IncorectFormatInstructionException, IncorrectFileException, IncorectFormatMaximalCoordinatesException {
		
		List <Mower> mowers = File.getMowerList(path);
		
		assertEquals(mowers.size(), 2);
		
		Mower mower = mowers.get(0);

		assertEquals(Orientation.N, mower.getOrientation());
		assertEquals(new Coordinates(1,2), mower.getCoordinates());
		assertEquals(setInstructionMower1(), mower.getInstructions());

		mower = mowers.get(1);
		
		assertEquals(Orientation.E, mower.getOrientation());
		assertEquals(new Coordinates(3,3), mower.getCoordinates());
		assertEquals(setInstructionMower2(), mower.getInstructions());
	}

	/**
	 * Test getCoordinatesMax method.
	 * 
	 * @throws IncorectFormatMaximalCoordinatesException
	 * @throws IncorrectFileException
	 */
	@Test
	public void getCoordinatesMax() throws IncorectFormatMaximalCoordinatesException, IncorrectFileException{
		
		Coordinates coordinatesFromFile = File.getCoordinatesMax(path);
		assertEquals(coordinatesFromFile, coordinatesMax);
	}

}
