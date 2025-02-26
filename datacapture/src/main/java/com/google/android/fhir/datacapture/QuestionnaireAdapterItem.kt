/*
 * Copyright 2022-2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.datacapture

import com.google.android.fhir.datacapture.views.QuestionnaireViewItem
import org.hl7.fhir.r4.model.QuestionnaireResponse

/** Various types of rows that can be used in a Questionnaire RecyclerView. */
internal sealed interface QuestionnaireAdapterItem {
  /** A row for a question in a Questionnaire RecyclerView. */
  data class Question(val item: QuestionnaireViewItem) : QuestionnaireAdapterItem

  /** A row for a repeated group response instance's header. */
  data class RepeatedGroupHeader(
    /** The response index. This is 0-indexed, but should be 1-indexed when rendered in the UI. */
    val index: Int,
    /** Callback that is invoked when the user clicks the delete button. */
    val onDeleteClicked: () -> Unit,
    /** Responses nested under this header. */
    val responses: List<QuestionnaireResponse.QuestionnaireResponseItemComponent>,
  ) : QuestionnaireAdapterItem
}
