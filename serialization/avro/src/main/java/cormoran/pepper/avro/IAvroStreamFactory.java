/**
 * The MIT License
 * Copyright (c) 2014 Benoit Lacelle
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package cormoran.pepper.avro;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.apache.avro.generic.GenericRecord;

import com.google.common.annotations.Beta;

/**
 * 
 * @author Benoit Lacelle
 *
 */
@Beta
public interface IAvroStreamFactory {

	/**
	 * @deprecated We prefer not to rely on java.nio.Path as it requires a {@link FileSystem} compatible with the Path
	 *             scheme. it would typically not work for swebhdfs scheme
	 */
	@Deprecated
	default Stream<GenericRecord> toStream(Path javaPath) throws IOException {
		return toStream(javaPath.toUri());
	}

	Stream<GenericRecord> toStream(URI uri) throws IOException;

	/**
	 * @deprecated We prefer not to rely on java.nio.Path as it requires a {@link FileSystem} compatible with the Path
	 *             scheme. it would typically not work for swebhdfs scheme
	 */
	@Deprecated
	default long writeToPath(Path javaPath, Stream<? extends GenericRecord> rowsToWrite) throws IOException {
		return writeToPath(javaPath.toUri(), rowsToWrite);
	}

	long writeToPath(URI uri, Stream<? extends GenericRecord> rowsToWrite) throws IOException;
}
