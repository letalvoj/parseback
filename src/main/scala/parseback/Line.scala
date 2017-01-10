/*
 * Copyright 2017 Daniel Spiewak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package parseback

/**
 * @param base The full contents of the line
 * @param lineNo The line offset of this line within the larger input stream (0 indexed)
 * @param colNo The column offset into `base` (0 indexed)
 */
final case class Line(base: String, lineNo: Int = 0, colNo: Int = 0) {

  def head: Char = base charAt colNo

  def project: String = base substring colNo

  def isEmpty: Boolean = base.length == colNo

  def next: Option[Line] =
    if (colNo + 1 < base.length) Some(Line(base, lineNo, colNo + 1)) else None
}
