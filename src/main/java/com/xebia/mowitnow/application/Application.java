package com.xebia.mowitnow.application;

import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xebia.mowitnow.application.exception.ApplicationParametersParseException;
import com.xebia.mowitnow.application.exception.ApplicationTerminateException;
import com.xebia.mowitnow.application.exception.IncorectFormatCoordinatesOrientationException;
import com.xebia.mowitnow.application.exception.IncorectFormatInstructionException;
import com.xebia.mowitnow.application.exception.IncorectFormatMaximalCoordinatesException;
import com.xebia.mowitnow.application.exception.IncorrectFileException;
import com.xebia.mowitnow.application.model.Coordinates;
import com.xebia.mowitnow.application.model.ExitStatus;
import com.xebia.mowitnow.application.model.Mower;
import com.xebia.mowitnow.application.use_case.MowerService;
import com.xebia.mowitnow.application.utils.File;

/**
 * @author Michel
 *
 */
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		try {
			run(args);

		} catch (ApplicationTerminateException e) {
			System.exit(e.getExitStatus().getValue());
		}
	}

	private static void run(String[] args) throws ApplicationTerminateException {

		final ApplicationParameters applicationParameters = new ApplicationParameters();

		try {

			applicationParameters.parse(args);

		} catch (ApplicationParametersParseException e) {

			logError(e);
			terminateApplication(ExitStatus.EX_USAGE);
		}

		logStart();
		try {

			final MowerService mowerService = new MowerService();

			final Path path = applicationParameters.getPath();

			final Coordinates coordinatesMax = File.getGroundMaxCoordinates(path);
			List<Mower> mowers = mowerService.getMowersFromFile(path);
			mowerService.realizeInstructionsAll(mowers, coordinatesMax);
			mowerService.getAllLocalisations(mowers);

			logFin();
			terminateApplication(ExitStatus.EX_OK);

		} catch (IncorectFormatMaximalCoordinatesException e) {
			logError(e);
			terminateApplication(ExitStatus.EX_RUNEX);
		} catch (IncorectFormatCoordinatesOrientationException e) {
			logError(e);
			terminateApplication(ExitStatus.EX_RUNEX);
		} catch (IncorectFormatInstructionException e) {
			logError(e);
			terminateApplication(ExitStatus.EX_RUNEX);
		} catch (IncorrectFileException e) {
			logError(e);
			terminateApplication(ExitStatus.EX_RUNEX);
		}

	}

	private static void terminateApplication(ExitStatus exitStatus) throws ApplicationTerminateException {
		throw new ApplicationTerminateException(exitStatus);
	}

	private static void logStart() {
		LOGGER.info("Application Start");
	}

	private static void logFin() {
		LOGGER.info("Application End");
	}

	
	private static void logError(Exception e) {
		String emessage = e.getMessage();
		if (e.getCause() != null) {
			emessage += " [cause] " + e.getCause().getMessage();
		}
		LOGGER.error(emessage);
	}
}
