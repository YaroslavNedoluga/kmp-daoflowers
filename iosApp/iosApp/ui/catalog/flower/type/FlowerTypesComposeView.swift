//
//  ComposeView.swift
//  iosApp
//
//  Created by user on 04.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct FlowerTypesCompseView : UIViewControllerRepresentable {
    
    private var vm: FlowerTypesViewModel!
    
    init (vm: FlowerTypesViewModel) {
        self.vm = vm
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
            // Nothing
    }
    
    func makeUIViewController(context: Context) -> some UIViewController {
        FlowerTypesScreenKt.FlowerTypesViewController(vm: vm)
    }
}
