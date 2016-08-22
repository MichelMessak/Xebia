package com.xebia.mowitnow.application.use_case;

import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xebia.mowitnow.application.exception.IncorectFormatCoordinatesOrientationException;
import com.xebia.mowitnow.application.exception.IncorectFormatInstructionException;
import com.xebia.mowitnow.application.exception.IncorectFormatMaximalCoordinatesException;
import com.xebia.mowitnow.application.exception.IncorrectFileException;
import com.xebia.mowitnow.application.model.Coordinates;
import com.xebia.mowitnow.application.model.Instruction;
import com.xebia.mowitnow.application.model.Mower;
import com.xebia.mowitnow.application.model.Orientation;
import com.xebia.mowitnow.application.utils.File;

/**
 * Service dedicated to mowers.
 * 
 * @author Michel
 *
 */
public class MowerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MowerService.class);

	public MowerService() {

	}

	/**
	 * Retrieve all mowers from an input file
	 * 
	 * @param path
	 * @return mower's list
	 * @throws IncorectFormatCoordinatesOrientationException
	 * @throws IncorectFormatInstructionException
	 * @throws IncorrectFileException
	 * @throws IncorectFormatMaximalCoordinatesException
	 */
	public List<Mower> getMowersFromFile(Path path) throws IncorectFormatCoordinatesOrientationException,
			IncorectFormatInstructionException, IncorrectFileException, IncorectFormatMaximalCoordinatesException {

		List<Mower> mowers = File.getMowerList(path);
		return mowers;
	}

	/**
	 * Realize all mower's instructions from a mower list.
	 * 
	 * @param mowers
	 * @param coordinatesMax
	 */
	public void realizeInstructionsAll(List<Mower> mowers, Coordinates coordinatesMax) {

		for (Mower mower : mowers) {
			realizeInstructions(coordinatesMax, mower);
		}
	}

	/**
	 * Realize all mower's instructions.
	 * 
	 * @param coordinatesMax
	 * @param mower
	 */
	private void realizeInstructions(Coordinates coordinatesMax, Mower mower) {

		if (mower.getInstructions() != null) {

			for (Instruction instruction : mower.getInstructions()) {

				switch (instruction) {

				case A:
					forward(mower.getCoordinates(), mower.getOrientation(), coordinatesMax);
					break;
				case D:
					mower.setOrientation(getNewOrientation(mower.getOrientation(), instruction));
					break;
				case G:
					mower.setOrientation(getNewOrientation(mower.getOrientation(), instruction));
					break;
				default:
					break;
				}
			}
			mower.getInstructions().clear();
		}
	}

	/**
	 * Get the new mower's orientation
	 * 
	 * @param orientation
	 * @param instruction
	 * @return new Orientation
	 */
	private Orientation getNewOrientation(Orientation orientation, Instruction instruction) {

		int newOrientationValue = (orientation.getValue() + instruction.getValue());
		newOrientationValue = Math.floorMod(newOrientationValue, 4);

		orientation = Orientation.valueOf(newOrientationValue);

		return orientation;
	}

	/**
	 * Realize a forward intruction according to the current mower's orientation. 
	 * 
	 * @param coordinates
	 * @param orientation
	 * @param coordinatesMax
	 */
	private void forward(Coordinates coordinates, Orientation orientation, Coordinates coordinatesMax) {

		switch (orientation) {

		case N:
			goToNorth(coordinates, coordinatesMax.getY());
			break;
		case E:
			goToEast(coordinates, coordinatesMax.getX());
			break;
		case S:
			goToSouth(coordinates);
			break;
		case W:
			goToWest(coordinates);
			break;
		default:
			break;
		}
	}

	/**
	 * Calculates new coordinates after moving to East.
	 * 
	 * @param coordinates
	 * @param xMax
	 */
	private void goToEast(Coordinates coordinates, int xMax) {
		if (coordinates.getX() != xMax) {
			coordinates.setX(coordinates.getX() + 1);
		}
	}

	/**
	 * Calculates new coordinates after moving to West.
	 * 
	 * @param coordinates
	 */
	private void goToWest(Coordinates coordinates) {
		if (coordinates.getX() != 0) {
			coordinates.setX(coordinates.getX() - 1);
		}
	}

	/**
	 * Calculates new coordinates after moving to the North.
	 * 
	 * @param coordinates
	 * @param yMax
	 */
	private void goToNorth(Coordinates coordinates, int yMax) {
		if (coordinates.getY() != yMax) {
			coordinates.setY(coordinates.getY() + 1);
		}
	}

	/**
	 * Calculates new coordinates after moving to the South.
	 * 
	 * @param coordinates
	 */
	private void goToSouth(Coordinates coordinates) {
		if (coordinates.getY() != 0) {
			coordinates.setY(coordinates.getY() - 1);
		}
	}

	/**
	 * Log all mower's coordinates and orientation. 
	 * 
	 * @param mowers
	 */
	public void getAllLocalisations(List<Mower> mowers) {

		for (Mower mower : mowers) {
			LOGGER.info(mower.getCurrentCoordinatesAndOrientation());
		}
	}
}
