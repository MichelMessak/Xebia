package com.xebia.mowitnow.application.use_case;

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
import com.xebia.mowitnow.application.use_case.MowerService;

public class MowerServiceTest extends SetupTest {

	private MowerService mowerService;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();

		mowerService = new MowerService();
	}


	/**
	 * Test realizeInstructionsAll method.
	 */
	@Test
	public void realizeInstructionsAllTest() {

		mowerService.realizeInstructionsAll(mowers,coordinatesMax);

		Mower mower = mowers.get(0);
		
		assertTrue(new Coordinates(1, 3).equals(mowers.get(0).getCoordinates()));
		assertEquals(mower.getOrientation(), Orientation.N);

		mower = mowers.get(1);
		
		assertTrue(new Coordinates(5, 1).equals(mowers.get(1).getCoordinates()));
		assertEquals(mower.getOrientation(), Orientation.E);
		
	}
	
	/**
	 * 
	 * Test getMowersFromFile method.
	 * @throws IncorectFormatCoordinatesOrientationException
	 * @throws IncorectFormatInstructionException
	 * @throws IncorrectFileException
	 * @throws IncorectFormatMaximalCoordinatesException
	 */
	@Test
	public void getMowersFromFileTest() throws IncorectFormatCoordinatesOrientationException, IncorectFormatInstructionException, IncorrectFileException, IncorectFormatMaximalCoordinatesException{
		
		List<Mower> mowerList = mowerService.getMowersFromFile(path);
		
		assertEquals(mowerList.size(), 2);
		
		Mower mower = mowerList.get(0);

		assertEquals(Orientation.N, mower.getOrientation());
		assertEquals(new Coordinates(1,2), mower.getCoordinates());
		assertEquals(setInstructionMower1(), mower.getInstructions());

		mower = mowerList.get(1);
		
		assertEquals(Orientation.E, mower.getOrientation());
		assertEquals(new Coordinates(3,3), mower.getCoordinates());
		assertEquals(setInstructionMower2(), mower.getInstructions());
		
	}

}
