//
//  FlowerTypeViewModel.swift
//  iosApp
//
//  Created by user on 04.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

public class FlowerTypeObservableObject: ObservableObject {
    var wrapper: FlowerTypesViewModel
   
    init(wrapper: FlowerTypesViewModel) {
        self.wrapper = wrapper
    }
}

public extension FlowerTypesViewModel {
    func asObservableObject() -> FlowerTypeObservableObject {
        return FlowerTypeObservableObject(wrapper: self)
    }
}
