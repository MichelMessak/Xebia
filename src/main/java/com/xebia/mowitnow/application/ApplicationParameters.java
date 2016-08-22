package com.xebia.mowitnow.application;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.xebia.mowitnow.application.exception.ApplicationParametersParseException;
import com.xebia.mowitnow.application.model.ParametersName;

/**
 * 
 * Class to manage application's parameters. 
 *
 * Exemple : -source C:\Users\Michel\Desktop\test.txt
 * 
 * @author Michel
 *
 */
public class ApplicationParameters {

	private Path path;

	/**
	 * 
	 * Parsing inputs parameters.
	 * @param parameters
	 * @throws ApplicationParametersParseException
	 */
	public void parse(String[] parameters) throws ApplicationParametersParseException {

		final Map<String, String> parametersMap = new HashMap<String, String>();

		for (int index = 0; index <= parameters.length - 2; index += 2) {
			parametersMap.put(parameters[index], parameters[index + 1]);
		}

		checkExists(parametersMap, ParametersName.F_SOURCE);

		path = getFolderPathParameter(parametersMap.get(getCmdParametreName(ParametersName.F_SOURCE)));

	}

	/**
	 * Check if input's parameters exists in the application. 
	 * 
	 * @param parametresMap
	 * @param parameterName
	 * @throws ApplicationParametersParseException
	 */
	private void checkExists(final Map<String, String> parametresMap, ParametersName parameterName)
			throws ApplicationParametersParseException {
		if (!parametresMap.containsKey(getCmdParametreName(parameterName))) {
			throw new ApplicationParametersParseException(
					"Invalid input parameters: missing " + parameterName.getValue() + " parameter");
		}
	}

	/**
	 * Retrieve path value and check if it really exist.
	 * 
	 * @param folderPath
	 * @return souce path
	 * @throws ApplicationParametersParseException
	 */
	private Path getFolderPathParameter(String folderPath) throws ApplicationParametersParseException {
		try {
			final Path result = Paths.get(folderPath);

			if (!Files.exists(result)) {
				throw new ApplicationParametersParseException(
						"Invalid input parameters: " + folderPath + " does not exist.");
			}

			return result;

		} catch (InvalidPathException e) {
			throw new ApplicationParametersParseException(e);
		}
	}

	/**
	 * @param name
	 * @return parameter's name
	 */
	private static String getCmdParametreName(ParametersName name) {
		return "-" + name.getValue();
	}
	
	/**
	 * @return the path
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(Path path) {
		this.path = path;
	}
}
