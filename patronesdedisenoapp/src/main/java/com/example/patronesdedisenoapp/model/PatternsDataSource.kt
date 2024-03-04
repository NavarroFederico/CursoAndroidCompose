package com.example.patronesdedisenoapp.model

import androidx.annotation.DrawableRes
import com.example.patronesdedisenoapp.R

object PatternsDesignRepository {
    val patterns = listOf<PatternDesign>(
        PatternDesign(
            id = 1,
            nameRes = R.string.abstract_factory,
            descriptionRes = R.string.abstract_factory_description,
            imageRes = R.drawable.abstract_factory_image,
            patternType = PatternType.CREATIONAL,
            url = (R.string.url_abstract_factory)
        ),
        PatternDesign(
            id = 2,
            nameRes = R.string.factory_method,
            descriptionRes = R.string.factory_method_description,
            imageRes = R.drawable.factory_method_image,
            patternType = PatternType.CREATIONAL,
            url = (R.string.https_devexpert_io_factory_method)
        ),
        PatternDesign(
            id = 3,
            nameRes = R.string.builder,
            descriptionRes = R.string.builder_description,
            imageRes = R.drawable.builder_image,
            patternType = PatternType.CREATIONAL,
            url = (R.string.builder_url)
        ),
        PatternDesign(
            id = 4,
            nameRes = R.string.singleton,
            descriptionRes = R.string.singleton_description,
            imageRes = R.drawable.singleton_image,
            patternType = PatternType.CREATIONAL,
            url = (R.string.singleton_url)
        ),
        PatternDesign(
            id = 5,
            nameRes = R.string.prototype,
            descriptionRes = R.string.prototype_description,
            imageRes = R.drawable.prototype_image,
            patternType = PatternType.CREATIONAL,
            url = (R.string.prototype_url)
        ),
        PatternDesign(
            id = 6,
            nameRes = R.string.adapter,
            descriptionRes = R.string.adapter_description,
            imageRes = R.drawable.adapter_image,
            patternType = PatternType.STRUCTURAL,
            url = (R.string.adapter_url)
        ),
        PatternDesign(
            id = 7,
            nameRes = R.string.bridge,
            descriptionRes = R.string.bridge_description,
            imageRes = R.drawable.bridge_image,
            patternType = PatternType.STRUCTURAL,
            url = (R.string.bridge_url)
        ),
        PatternDesign(
            id = 8,
            nameRes = R.string.composite,
            descriptionRes = R.string.composite_description,
            imageRes = R.drawable.composite_image,
            patternType = PatternType.STRUCTURAL,
            url = (R.string.composite_url)
        ), PatternDesign(
            id = 9,
            nameRes = R.string.decorator,
            descriptionRes = R.string.decorator_description,
            imageRes = R.drawable.decorator_image,
            patternType = PatternType.STRUCTURAL,
            url = (R.string.decorator_url)
        ), PatternDesign(
            id = 10,
            nameRes = R.string.facade,
            descriptionRes = R.string.facade_description,
            imageRes = R.drawable.facade_image,
            patternType = PatternType.STRUCTURAL,
            url = (R.string.facade_url)
        ), PatternDesign(
            id = 11,
            nameRes = R.string.flyweight,
            descriptionRes = R.string.flyweight_description,
            imageRes = R.drawable.flyweight_image,
            patternType = PatternType.STRUCTURAL,
            url = (R.string.flyweight_url)
        ), PatternDesign(
            id = 12,
            nameRes = R.string.proxy,
            descriptionRes = R.string.proxy_description,
            imageRes = R.drawable.proxy_image,
            patternType = PatternType.STRUCTURAL,
            url = (R.string.proxy_url)
        ),
        PatternDesign(
            id = 13,
            nameRes = R.string.command,
            descriptionRes = R.string.command_description,
            imageRes = R.drawable.command_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.command_url)
        ),
        PatternDesign(
            id = 14,
            nameRes = R.string.chain_of_responsability,
            descriptionRes = R.string.chain_of_responsability_description,
            imageRes = R.drawable.chain_of_responsibility,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.chain_of_responsibility_url)
        ), PatternDesign(
            id = 15,
            nameRes = R.string.interpreter,
            descriptionRes = R.string.interpreter_description,
            imageRes = R.drawable.interpreter_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.interpreter_url)
        ), PatternDesign(
            id = 16,
            nameRes = R.string.iterator,
            descriptionRes = R.string.iterator_description,
            imageRes = R.drawable.iterator_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.iterator_url)
        ), PatternDesign(
            id = 17,
            nameRes = R.string.mediator,
            descriptionRes = R.string.mediator_description,
            imageRes = R.drawable.mediator_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.mediator_url)
        ), PatternDesign(
            id = 18,
            nameRes = R.string.memento,
            descriptionRes = R.string.memento_description,
            imageRes = R.drawable.memento_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.memento_url)
        ), PatternDesign(
            id = 19,
            nameRes = R.string.observer,
            descriptionRes = R.string.observer_description,
            imageRes = R.drawable.observer_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.observer_url)
        ), PatternDesign(
            id = 20,
            nameRes = R.string.state,
            descriptionRes = R.string.state_description,
            imageRes = R.drawable.state_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.state_url)
        ),
        PatternDesign(
            id = 21,
            nameRes = R.string.strategy,
            descriptionRes = R.string.strategy_description,
            imageRes = R.drawable.strategy_imagen,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.strategy_url)
        ),
        PatternDesign(
            id = 22,
            nameRes = R.string.template_method,
            descriptionRes = R.string.template_method,
            imageRes = R.drawable.template_method_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.template_method_url)
        ),
        PatternDesign(
            id = 23,
            nameRes = R.string.visitor,
            descriptionRes = R.string.visitor_description,
            imageRes = R.drawable.visitor_image,
            patternType = PatternType.BEHAVIORAL,
            url = (R.string.visitor_url)
        )
    )
}