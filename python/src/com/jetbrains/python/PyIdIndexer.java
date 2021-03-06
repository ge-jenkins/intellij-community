/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jetbrains.python;

import com.intellij.lexer.Lexer;
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer;
import com.intellij.psi.impl.cache.impl.id.LexerBasedIdIndexer;
import com.jetbrains.python.lexer.PythonLexer;

/**
 * @author traff
 */
public class PyIdIndexer extends LexerBasedIdIndexer {
  @Override
  public Lexer createLexer(OccurrenceConsumer consumer) {
    return createIndexingLexer(consumer);
  }

  public static Lexer createIndexingLexer(OccurrenceConsumer consumer) {
    return new PyFilterLexer(new PythonLexer(), consumer);
  }
}
